package dataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSource {

	private static DataSource datasource;
	private BasicDataSource ds;
	private static Properties prop = new Properties();

	DataSource() throws IOException, SQLException, PropertyVetoException {
		readProperties();
		ds = new BasicDataSource();
		ds.setDriverClassName(prop.getProperty("classname"));
		ds.setUsername(prop.getProperty("user"));
		ds.setPassword(prop.getProperty("password"));
		ds.setUrl(prop.getProperty("url"));

		// the settings below are optional -- dbcp can work with defaults
		ds.setMinIdle(Integer.parseInt(prop.getProperty("minidle")));
		ds.setMaxIdle(Integer.parseInt(prop.getProperty("maxidle")));
		ds.setMaxOpenPreparedStatements(Integer.parseInt(prop.getProperty("maxopenpreparedstmt")));

	}

	public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
		if (datasource == null) {
			datasource = new DataSource();
			return datasource;
		} else {
			return datasource;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.ds.getConnection();
	}

	private static void readProperties() {
		InputStream input = null;
		try {
			input = new FileInputStream("resource\\db.properties");
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}