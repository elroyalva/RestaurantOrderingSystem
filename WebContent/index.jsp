<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant Ordering System Login</title>
</head>
<body>
	<h1>Restaurant Ordering System</h1>
	<html:form action="login">
		<html:errors />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true">
				<bean:write name="message" />
				<br />
			</html:messages>
		</logic:messagesPresent>
		<br />
		<br />
		<table style="width: 25%">
			<tr>
				<td><bean:message key="label.username" /></td>
				<td><html:text property="userName"></html:text></td>
			</tr>
			<tr>
				<td><bean:message key="label.password" /></td>
				<td><html:password property="password"></html:password></td>
			</tr>
			<tr>
				<td><bean:message key="label.usertype" /></td>
				<td><input type="radio" name="userType" value="C" checked>Customer<br>
					<input type="radio" name="userType" value="K" checked>Kitchen<br>
					<input type="radio" name="userType" value="R">Restaurant</td>
			</tr>
		</table>
		<br>
		<br>
		<html:submit />
		<html:reset />
	</html:form>
	<a href="sign_up.jsp">Signup for a new restaurant here</a>
</body>
</html>