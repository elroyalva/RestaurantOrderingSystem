package dataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

public class DataSource {

	final static Logger logger = Logger.getLogger(DataSource.class);
	private static DataSource datasource;
	private BasicDataSource ds;
	private static Properties prop = new Properties();

	DataSource()  {
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

	public static DataSource getInstance()  {
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

	private void readProperties() {
		InputStream input = null;
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
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