<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
	<link rel="stylesheet" href="login.css" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Restaurant Ordering System Login</title>
</head>
<body background="background1.jpg">
	<h1>Restaurant Ordering System</h1>
	<html:form action="/login">
	<!-- Validations and Error Messages -->
		<html:errors />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true">
				<bean:write name="message" />
				<br />
			</html:messages>
		</logic:messagesPresent>
		
		<br />
		<br />

		<!-- Login form -->
		<div class="container">
		<br>
		<h2>
		<table align="center">
				<tr>
					<td><h2><b>Username:</b></h2></td>
					<td><h2><input type="text" name="userName" id="userName"></h2></input></td>
				</tr>

				<tr>
					<td><h2><b>Password:</b></h2></td>
					<td><h2><input type="password" name="password" id="password"></h2></input></td>
				</tr>
				
				<tr>
					<td><h2><b>User Type:</b></h2></td>
					<td><h2><b><input type="radio" name="userType" value="C" checked>Customer<br>
						<input type="radio" name="userType" value="K" checked>Kitchen<br>
						<input type="radio" name="userType" value="R">Restaurant</b></h2></td>
				</tr>
			</table>
		</h2>
		<br>
		<br>
		<input type="submit" name="submit" value="Submit" id="submit"/>
		&nbsp;&nbsp;&nbsp;
		<input type="reset" name="reset" value="Reset" id="reset"/>
		<br><br>
		</div>
	</html:form>

	<br><br>
	
	<!-- Sign up link -->
	<b><a href="/RestaurantOrderingSystem/sign_up.jsp">Sign up for a new restaurant here</a></b>
</body>
</html>