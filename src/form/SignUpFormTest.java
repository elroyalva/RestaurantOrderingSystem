package form;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.junit.Test;

public class SignUpFormTest {

	SignUpForm form = new SignUpForm();
	
	@Test
	public void testValidateActionMappingHttpServletRequest() {
		ActionMapping map = new ActionMapping();
		HttpServletRequest request = null;
		SignUpForm form = new SignUpForm();
		ActionErrors errors = form.validate(map, request);
		assertEquals(errors.isEmpty(),false);
	}

	@Test
	public void testGetName() {
		form.setName("Wayne");
		assertEquals(form.getName(),"Wayne");
	}

	@Test
	public void testSetName() {
		form.setName("Wayne");
		assertEquals(form.getName(),"Wayne");
	}

	@Test
	public void testGetAddress() {
		form.setAddress("Addr");
		assertEquals(form.getAddress(),"Addr");
	}

	@Test
	public void testSetAddress() {
		form.setAddress("Addr");
		assertEquals(form.getAddress(),"Addr");
	}

	@Test
	public void testGetPhone() {
		form.setPhone("1234567890");
		assertEquals(form.getPhone(),"1234567890");
	}

	@Test
	public void testSetPhone() {
		form.setPhone("1234567890");
		assertEquals(form.getPhone(),"1234567890");
	}

	@Test
	public void testGetEmail() {
		form.setEmail("abcd@gmail.com");
		assertEquals(form.getEmail(),"abcd@gmail.com");
	}

	@Test
	public void testSetEmail() {
		form.setEmail("abcd@gmail.com");
		assertEquals(form.getEmail(),"abcd@gmail.com");
	}

	@Test
	public void testGetTableCount() {
		form.setTableCount("5");
		assertEquals(form.getTableCount(),"5");
	}

	@Test
	public void testSetTableCount() {
		form.setTableCount("5");
		assertEquals(form.getTableCount(),"5");
	}

	@Test
	public void testGetTax() {
		form.setTax("3");
		assertEquals(form.getTax(),"3");
	}

	@Test
	public void testSetTax() {
		form.setTax("3");
		assertEquals(form.getTax(),"3");
	}

	@Test
	public void testGetUserNameAdmin() {
		form.setUserNameAdmin("Admin");
		assertEquals(form.getUserNameAdmin(),"Admin");
	}

	@Test
	public void testSetUserNameAdmin() {
		form.setUserNameAdmin("Admin");
		assertEquals(form.getUserNameAdmin(),"Admin");
	}

	@Test
	public void testGetPasswordAdmin() {
		form.setPasswordAdmin("Adminpass");
		assertEquals(form.getPasswordAdmin(),"Adminpass");
	}

	@Test
	public void testSetPasswordAdmin() {
		form.setPasswordAdmin("Adminpass");
		assertEquals(form.getPasswordAdmin(),"Adminpass");
	}

	@Test
	public void testGetPasswordAdmin1() {
		form.setPasswordAdmin1("Adminpass1");
		assertEquals(form.getPasswordAdmin1(),"Adminpass1");
	}

	@Test
	public void testSetPasswordAdmin1() {
		form.setPasswordAdmin1("Adminpass1");
		assertEquals(form.getPasswordAdmin1(),"Adminpass1");
	}

	@Test
	public void testGetUserNameCust() {
		form.setUserNameCust("Cust");
		assertEquals(form.getUserNameCust(),"Cust");
	}

	@Test
	public void testSetUserNameCust() {
		form.setUserNameCust("Cust");
		assertEquals(form.getUserNameCust(),"Cust");
	}

	@Test
	public void testGetPasswordCust() {
		form.setPasswordCust("Custpass");
		assertEquals(form.getPasswordCust(),"Custpass");
	}

	@Test
	public void testSetPasswordCust() {
		form.setPasswordCust("Custpass");
		assertEquals(form.getPasswordCust(),"Custpass");
	}

	@Test
	public void testGetPasswordCust1() {
		form.setPasswordCust1("Custpass1");
		assertEquals(form.getPasswordCust1(),"Custpass1");
	}

	@Test
	public void testSetPasswordCust1() {
		form.setPasswordCust1("Custpass1");
		assertEquals(form.getPasswordCust1(),"Custpass1");
	}

	@Test
	public void testGetUserNameKitchen() {
		form.setUserNameKitchen("UserKit");
		assertEquals(form.getUserNameKitchen(),"UserKit");
	}

	@Test
	public void testSetUserNameKitchen() {
		form.setUserNameKitchen("UserKit");
		assertEquals(form.getUserNameKitchen(),"UserKit");
	}

	@Test
	public void testGetPasswordKitchen() {
		form.setPasswordKitchen("PassKit");
		assertEquals(form.getPasswordKitchen(),"PassKit");
	}

	@Test
	public void testSetPasswordKitchen() {
		form.setPasswordKitchen("PassKit");
		assertEquals(form.getPasswordKitchen(),"PassKit");
	}

	@Test
	public void testGetPasswordKitchen1() {
		form.setPasswordKitchen1("PassKit1");
		assertEquals(form.getPasswordKitchen1(),"PassKit1");
	}

	@Test
	public void testSetPasswordKitchen1() {
		form.setPasswordKitchen1("PassKit1");
		assertEquals(form.getPasswordKitchen1(),"PassKit1");
	}

}
