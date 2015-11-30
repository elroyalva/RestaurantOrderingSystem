package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import form.SignUpForm;
import utility.SignUpUtility;

public class SignUpAction extends Action {
	
	final static Logger logger = Logger.getLogger(SignUpAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)  {
		ActionErrors actionErrors = new ActionErrors();
		ActionMessages messages = new ActionMessages();
		String target;
		
		SignUpUtility sUtil = new SignUpUtility();
		SignUpForm sForm = (SignUpForm) form;
		int records = sUtil.insertData(sForm);
		
		if (records >0) {
			messages.add("", new ActionMessage("add.successful"));
			target = "success";
		} else {
			target = "failure";
			logger.error("Record could not be added");
		}
		
		saveMessages(request, messages);
		addErrors(request, actionErrors);
		return mapping.findForward(target);
	}

}
