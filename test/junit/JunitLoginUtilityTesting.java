package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dataSource.DataSource;
import utility.LoginUtility;

public class JunitLoginUtilityTesting {

	Connection con;
	LoginUtility login;
	String username, password, usertype;

	@Before
	public void setUp() throws SQLException  {
		login = new LoginUtility();
		DataSource ds = DataSource.getInstance();
		con = ds.getConnection();
		username = "Starbucks";
		password = "Starbucks";
		usertype = "C";
	}

	// test case for db connection
	@Test
	public void TestConnection() throws SQLException {
		assertNotNull(con.getAutoCommit());
	}

	// test login
	@Test
	public void TestValidateLogin()  {
		boolean b = login.validateLogin(username, password, usertype);
		assertEquals(b, true);
	}

	// validate encrypt
	@Test
	public void TestValidateEncrypt() {
		String encrypt = login.encrypt(password);
		assertEquals(encrypt, "880ceb49c6bf9f39968534b121ab149a505feaa70c30753851eb87f6c208f68a");
	}

	// validate restaurant id
	@Test
	public void TestRestaurantId()  {
		int resid = login.getRestaurantId(username);
		assertTrue(resid != -1);

	}

	// validate table data
	@Test
	public void TestTableData()  {
		Map<Integer, Set<Integer>> data = login.getTableData();
		assertNotNull(data);
	}
}