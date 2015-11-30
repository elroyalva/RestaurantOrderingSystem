package form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class SignUpForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String address;
	private String phone;
	private String email;
	private String tableCount;
	private String tax;
	private FormFile image;
	private FormFile logo;
	private String userNameAdmin;
	private String passwordAdmin;
	private String passwordAdmin1;
	private String userNameCust;
	private String passwordCust;
	private String passwordCust1;
	private String userNameKitchen;
	private String passwordKitchen;
	private String passwordKitchen1;

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors = new ActionErrors();

		checkNull(actionErrors, name, "Restaurant Name ");
		checkNull(actionErrors, address, "Restaurant Address ");
		checkNull(actionErrors, phone, "Restaurant Phone Number ");
		checkNull(actionErrors, email, "Restaurant Email Id ");
		checkNull(actionErrors, tableCount, "Table Count ");
		checkNull(actionErrors, tax, "Tax Percentage ");
		checkNull(actionErrors, userNameAdmin, "Restaurant Admin Username ");
		checkNull(actionErrors, passwordAdmin, "Restaurant Admin Password ");
		checkNull(actionErrors, userNameCust, "Restaurant Customer Login Username ");
		checkNull(actionErrors, passwordCust, "Restaurant Customer Login Password ");
		checkNull(actionErrors, userNameKitchen, "Restaurant Kitchen Username ");
		checkNull(actionErrors, passwordKitchen, "Restaurant Kitchen Password ");
		checkNull(actionErrors, passwordAdmin1, "Restaurant Admin Confirm Password ");
		checkNull(actionErrors, passwordCust1, "Restaurant Customer Login Confirm Password ");
		checkNull(actionErrors, passwordKitchen1, "Restaurant Kitchen Confirm Password ");

		matchPasswords(actionErrors, passwordAdmin, passwordAdmin1, "Restaurant Admin ");
		matchPasswords(actionErrors, passwordCust, passwordCust1, "Restaurant Customer ");
		matchPasswords(actionErrors, passwordKitchen, passwordKitchen1, "Restaurant Kitchen ");

		checkImage(actionErrors, image, " Restaurant Image");
		checkImage(actionErrors, logo, " Restaurant Logo");

		return actionErrors;
	}

	private void checkImage(ActionErrors actionErrors, FormFile image2, String string) {
		if (image2 == null || "".equals(image2.getFileName())) {
			actionErrors.add("", new ActionMessage("image.notFound", string));
		}
	}

	private void matchPasswords(ActionErrors actionErrors, String passwordAdmin2, String passwordAdmin12,
			String string) {
		if (!isEmptyOrNull(passwordAdmin2) && !isEmptyOrNull(passwordAdmin12)
				&& !passwordAdmin2.equals(passwordAdmin12)) {
			actionErrors.add("password", new ActionMessage("password.match", string));
		}
	}

	private boolean isEmptyOrNull(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}

	private void checkNull(ActionErrors actionErrors, String field, String fieldName) {
		if (field == null || "".equals(field)) {
			actionErrors.add(fieldName, new ActionMessage("checkNull", fieldName));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTableCount() {
		return tableCount;
	}

	public void setTableCount(String tableCount) {
		this.tableCount = tableCount;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public void setImage(FormFile image) {
		this.image = image;
	}

	public void setLogo(FormFile logo) {
		this.logo = logo;
	}

	public FormFile getImage() {
		return image;
	}

	public FormFile getLogo() {
		return logo;
	}

	public String getUserNameAdmin() {
		return userNameAdmin;
	}

	public void setUserNameAdmin(String userNameAdmin) {
		this.userNameAdmin = userNameAdmin;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	public String getPasswordAdmin1() {
		return passwordAdmin1;
	}

	public void setPasswordAdmin1(String passwordAdmin1) {
		this.passwordAdmin1 = passwordAdmin1;
	}

	public String getUserNameCust() {
		return userNameCust;
	}

	public void setUserNameCust(String userNameCust) {
		this.userNameCust = userNameCust;
	}

	public String getPasswordCust() {
		return passwordCust;
	}

	public void setPasswordCust(String passwordCust) {
		this.passwordCust = passwordCust;
	}

	public String getPasswordCust1() {
		return passwordCust1;
	}

	public void setPasswordCust1(String passwordCust1) {
		this.passwordCust1 = passwordCust1;
	}

	public String getUserNameKitchen() {
		return userNameKitchen;
	}

	public void setUserNameKitchen(String userNameKitchen) {
		this.userNameKitchen = userNameKitchen;
	}

	public String getPasswordKitchen() {
		return passwordKitchen;
	}

	public void setPasswordKitchen(String passwordKitchen) {
		this.passwordKitchen = passwordKitchen;
	}

	public String getPasswordKitchen1() {
		return passwordKitchen1;
	}

	public void setPasswordKitchen1(String passwordKitchen1) {
		this.passwordKitchen1 = passwordKitchen1;
	}

}
