package form;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.junit.Test;

public class LoginFormTest {

	LoginForm form = new LoginForm();
	
	@Test
	public void testValidateActionMappingHttpServletRequest1() {
		ActionMapping map = new ActionMapping();
		HttpServletRequest request = null;
		LoginForm form = new LoginForm();
		form.setUserName("Ryan");
		form.setPassword("Giggs");
		form.setUserType("R");
		ActionErrors errors = form.validate(map, request);
		assertEquals(errors.isEmpty(),true);
	}

	@Test
	public void testValidateActionMappingHttpServletRequest2() {
		ActionMapping map = new ActionMapping();
		HttpServletRequest request = null;
		LoginForm form = new LoginForm();
		form.setUserName(null);
		form.setPassword(null);
		form.setUserType(null);
		ActionErrors errors = form.validate(map, request);
		assertEquals(errors.isEmpty(),false);
	}
	
	@Test
	public void testValidateActionMappingHttpServletRequest3() {
		ActionMapping map = new ActionMapping();
		HttpServletRequest request = null;
		LoginForm form = new LoginForm();
		form.setUserName("some name");
		form.setPassword(null);
		form.setUserType(null);
		ActionErrors errors = form.validate(map, request);
		assertEquals(errors.isEmpty(),false);
	}
	
	@Test
	public void testGetUserName() {
		form.setUserName("David");
		assertEquals(form.getUserName(),"David");
	}

	@Test
	public void testSetUserName() {
		form.setUserName("John");
		assertEquals(form.getUserName(),"John");
	}

	@Test
	public void testGetPassword() {
		form.setPassword("password");
		assertEquals(form.getPassword(),"password");
	}

	@Test
	public void testSetPassword() {
		form.setPassword("password");
		assertEquals(form.getPassword(),"password");
	}

	@Test
	public void testGetUserType() {
		form.setUserType("C");
		assertEquals(form.getUserType(),"C");
	}

	@Test
	public void testSetUserType() {
		form.setUserType("C");
		assertEquals(form.getUserType(),"C");
	}

}
