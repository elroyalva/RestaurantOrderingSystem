package form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LoginForm.class);
	private String userName;
	private String password;
	private String userType;

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors actionErrors = new ActionErrors();

		if (userName == null || "".equals(userName.trim())) {
			actionErrors.add("userName", new ActionMessage("error.username"));
			logger.info("Error in validating username");
		}
		if (userType == null || "".equals(userType.trim())) {
			actionErrors.add("userType", new ActionMessage("error.usertype"));
			logger.info("Error in validating user type");
		}
		try {
			if (password == null || "".equals(password.trim())) {
				actionErrors.add("password", new ActionMessage("error.password"));
				logger.info("Error in validating user password");
			}
		} catch (Exception e) {
			logger.error("Exception :" + e.getStackTrace());
			logger.error("Message :" + e.getMessage());
			logger.info(e);
		}
		return actionErrors;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
