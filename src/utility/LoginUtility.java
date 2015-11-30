package utility;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.bouncycastle.jcajce.provider.digest.SHA3.DigestSHA3;
import org.bouncycastle.util.encoders.Hex;

import dataSource.DataSource;

public class LoginUtility {

	final static Logger logger = Logger.getLogger(LoginUtility.class);

	public boolean validateLogin(String userName, String password, String userType) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.LOGIN_QUERY);
			ps.setString(1, userName);
			ps.setString(2, encrypt(password));
			ps.setString(3, userType);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return false;
	}

	public String encrypt(String password) {
		DigestSHA3 digest = new DigestSHA3(256);
		try {
			digest.update(password.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			digest.update(password.getBytes());
			logger.info("UnsupportedEncodingException occured. But it's taken care of");
			logger.info(e);
		}
		byte[] encrypt = digest.digest();
		return Hex.toHexString(encrypt);
	}

	public int getRestaurantId(String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.GET_RESTAURANT_ID_QUERY);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				int retVal = rs.getInt(1);
				return retVal;
			}
			return -1;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return -1;
	}

	public Map<Integer, Set<Integer>> getTableData() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<Integer, Set<Integer>> data = new HashMap<Integer, Set<Integer>>();
		try {
			Set<Integer> tabList = null;
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.TABLE_DATA);
			rs = ps.executeQuery();
			while (rs.next()) {
				int restId = rs.getInt(1);
				int tableCount = rs.getInt(2);
				tabList = new HashSet<Integer>();
				for (int i = 1; i <= tableCount; i++) {
					tabList.add(i);
				}
				data.put(restId, tabList);
			}
			return data;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return data;

	}
}