package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;
import org.bouncycastle.jcajce.provider.digest.SHA3.DigestSHA3;
import org.bouncycastle.util.encoders.Hex;

import dataSource.DataSource;
import form.SignUpForm;

public class SignUpUtility {

	private static Properties prop = new Properties();
	final static Logger logger = Logger.getLogger(SignUpUtility.class);

	public int insertData(SignUpForm sForm) {
		try {
			readProperties();
			int id = getIdFromRestroTable() + 1;
			insertRestroData(sForm, id);
			insertAdminUser(sForm, id);
			insertCustUser(sForm, id);
			insertKitchenUser(sForm, id);
			return 1;
		} catch (Exception e) {
			logger.error("Exception :" + e.getStackTrace());
			logger.error("Message :" + e.getMessage());
			logger.info(e);
		}
		return 0;
	}

	private void insertKitchenUser(SignUpForm sForm, int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.INSERT_INTO_LOGIN);
			ps.setString(1, sForm.getUserNameKitchen());
			ps.setString(2, encrypt(sForm.getPasswordKitchen()));
			ps.setString(3, "K");
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
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
	}

	private void insertCustUser(SignUpForm sForm, int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.INSERT_INTO_LOGIN);
			ps.setString(1, sForm.getUserNameCust());
			ps.setString(2, encrypt(sForm.getPasswordCust()));
			ps.setString(3, "C");
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
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
	}

	private void insertAdminUser(SignUpForm sForm, int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.INSERT_INTO_LOGIN);
			ps.setString(1, sForm.getUserNameAdmin());
			ps.setString(2, encrypt(sForm.getPasswordAdmin()));
			ps.setString(3, "R");
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
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
	}

	private String encrypt(String password) {
		DigestSHA3 digest = new DigestSHA3(256);
		try {
			digest.update(password.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			digest.update(password.getBytes());
			logger.info("UnsupportedEncodingException occurred. But it's taken care of");
			logger.info(e);
		}
		byte[] encrypt = digest.digest();
		return Hex.toHexString(encrypt);
	}

	private void insertRestroData(SignUpForm sForm, int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.INSERT_INTO_RESTAURANT);
			ps.setInt(1, id);
			ps.setString(2, sForm.getName());
			ps.setString(3, sForm.getAddress());
			ps.setString(4, sForm.getPhone());
			ps.setString(5, sForm.getEmail());
			ps.setInt(6, Integer.parseInt(sForm.getTableCount()));
			ps.setFloat(7, Float.parseFloat(sForm.getTax()));
			ps.setString(8, getImageURL(sForm.getImage(), id));
			ps.setString(9, getLogoURL(sForm.getLogo(), id));
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
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
	}

	private String getLogoURL(FormFile logo, int id) {
		OutputStream bos = null;
		InputStream stream = null;
		String fileName = String.valueOf(id) + "_" + logo.getFileName();
		String directory = prop.getProperty("imagesPath");
		String createPath = prop.getProperty("imageCreate");
		try {
			File f = new File(directory);
			if (!f.exists()) {
				f.mkdir();
			}
			if (!"".equals(fileName)) {
				stream = logo.getInputStream();
				bos = new FileOutputStream(createPath + fileName);
				byte[] buffer = new byte[8192];
				int bytesRead;
				while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
					bos.write(buffer, 0, bytesRead);
				}
				bos.close();
				stream.close();
			}
		} catch (FileNotFoundException e) {
			logger.info(e);
		} catch (IOException e) {
			logger.info(e);
		}
		return "/RestaurantOrderingSystem/images/" + fileName;
	}

	private String getImageURL(FormFile image, int id) {
		OutputStream bos = null;
		InputStream stream = null;
		String fileName = String.valueOf(id) + "_" + image.getFileName();
		String directory = prop.getProperty("imagesPath");
		String createPath = prop.getProperty("imageCreate");
		try {
			File f = new File(directory);
			if (!f.exists()) {
				f.mkdir();
			}
			if (!"".equals(fileName)) {
				stream = image.getInputStream();
				bos = new FileOutputStream(createPath + fileName);
				byte[] buffer = new byte[8192];
				int bytesRead;
				while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
					bos.write(buffer, 0, bytesRead);
				}
				bos.close();
				stream.close();
			}
		} catch (FileNotFoundException e) {
			logger.info(e);
		} catch (IOException e) {
			logger.info(e);
		}
		return "/RestaurantOrderingSystem/images/" + fileName;
	}

	public int getIdFromRestroTable() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.GET_MAX_ID);
			rs = ps.executeQuery();
			if (rs.next()) {
				int retVal = rs.getInt(1);
				return retVal;
			}
			con.close();
			return 1;
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
		return 1;
	}

	private void readProperties() {
		InputStream input = null;
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException ex) {
			logger.error("IOException :" + ex.getStackTrace());
			logger.error("Message :" + ex.getMessage());
			logger.info(ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("IOException :" + e.getStackTrace());
					logger.error("Message :" + e.getMessage());
					logger.info(e);
				}
			}
		}
	}
}
