package dataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class SelectQuery {

	public static void main(String[] args) throws SQLException, IOException, PropertyVetoException {
		Connection con = DataSource.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("select * from login");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			String username = rs.getString("username");
			String password = rs.getString("password");
			System.out.println("User: "+username+", Password: "+password);
		}

	}

}
