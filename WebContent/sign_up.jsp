<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
	<link rel="stylesheet" href="sign_up.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sign up for the new Restaurant</title>
</head>
<body background="background1.jpg">
	<h1>Restaurant Sign Up</h1>
	<form action="signup" enctype="multipart/form-data">
	<h3>
		<html:errors />
		<br />
		</h3>
		<div class="container">
			<br>
			<h2>
		<table align="center">
			<tr>
				<td align="center" colspan="2"><h2>Please Enter the	Following Details</h2>
			</tr>
			<tr>
				<td align="left"><b>Name :</b></td>
				<td align="left"><input type="text" name="name" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="left"><b>Address :</b></td>
				<td align="left"><textarea name="address" cols="32" rows="3" /></textarea></td>
			</tr>
			<tr>
				<td align="left"><b>E-mail address :</b></td>
				<td align="left"><input type="text" name="email" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="left"><b>Phone :</b></td>
				<td align="left"><input type="text" name="phone" size="30" maxlength="15" /></td>
			</tr>
			<tr>
				<td align="left"><b>Number of tables :</b></td>
				<td align="left"><input type="text" name="tableCount" size="30" maxlength="3" /></td>
			</tr>
			<tr>
				<td align="left"><b>Tax % :</b></td>
				<td align="left"><input type="text" name="tax" size="30" maxlength="5" /></td>
			</tr>
			<tr>
				<td align="left"><b>Restaurant Image :</b></td>
				<td align="left"><input type="file" name="image" /></td>
			</tr>
			<tr>
				<td align="left"><b>Restaurant Logo :</b></td>
				<td align="left"><input type="file" name="logo" /></td>
			</tr>
			<tr>
				<td align="left"><b>Restaurant Admin Username :</b></td>
				<td align="left"><input type="text" name="userNameAdmin" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="left"><b>Restaurant Admin Password :</b></td>
				<td align="left"><input type="password" name="passwordAdmin" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="left"><b>Confirm Password :</b></td>
				<td align="left"><input type="password" name="passwordAdmin1" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="left"><b>Restaurant Customer Username :</b></td>
				<td align="left"><input type="text" name="userNameCust" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="left"><b>Restaurant Customer Password :</b></td>
				<td align="left"><input type="password" name="passwordCust" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="left"><b>Confirm Password :</b></td>
				<td align="left"><input type="password" name="passwordCust1" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="left"><b>Restaurant Kitchen Username :</b></td>
				<td align="left"><input type="text" name="userNameKitchen" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="left"><b>Restaurant Kitchen Password :</b></td>
				<td align="left"><input type="password" name="passwordKitchen" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="left"><b>Confirm Password :</b></td>
				<td align="left"><input type="password" name="passwordKitchen1" size="30" maxlength="30" /></td>
			</tr>
		</table>
		</h2>
		<br>
		<br>
		<input type="submit" name="submit" value="Sign Up" id="submit" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" name="reset" value="Reset" id="reset" />
		<br><br>
	</div>
	</form>
</body>
</html>