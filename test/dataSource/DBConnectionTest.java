package dataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {

	public static void main(String[] args) throws IOException, SQLException, PropertyVetoException {
		DataSource ds = DataSource.getInstance();
		Connection con = ds.getConnection();
		System.out.println(con.getAutoCommit());
	}

}
