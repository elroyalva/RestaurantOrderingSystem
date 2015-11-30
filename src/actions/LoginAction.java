package actions;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.LoginForm;
import utility.LoginUtility;
import utility.RestaurantUtility;

public class LoginAction extends Action {
	
	final static Logger logger = Logger.getLogger(LoginAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)  {
		ActionErrors actionErrors = new ActionErrors();
		String target = null;
		LoginForm loginForm = (LoginForm) form;

		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		String userType = loginForm.getUserType();

		LoginUtility loginUtility = new LoginUtility();
		boolean isValid = loginUtility.validateLogin(userName, password, userType);

		if (isValid) {
			if ("C".equals(userType)) {
				target = "successC";
				RestaurantUtility restUtility = new RestaurantUtility();
				String JSON = restUtility.getMenu(userName);
				request.getSession().setAttribute("message", JSON);
				updateTableData(loginUtility);
			} else if ("K".equals(userType)) {
				target = "successK";
			}
			request.getSession().setAttribute("rest_id", loginUtility.getRestaurantId(userName));
		} else {
			target = "failure";
			actionErrors.add("userName", new ActionMessage("invalid.login"));
			logger.error("Invalid Login");
		}

		addErrors(request, actionErrors);
		return mapping.findForward(target);
	}

	private void updateTableData(LoginUtility loginUtility)  {
		if (getServlet().getServletContext().getAttribute("table_data") == null) {
			Map<Integer, Set<Integer>> data = loginUtility.getTableData();
			getServlet().getServletContext().setAttribute("table_data", data);
		}
	}

}
