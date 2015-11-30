<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="select_table.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select a Table</title>
</head>
<body background="background1.jpg">
<h1>Select Tables</h1><br><br>
<form action="/RestaurantOrderingSystem/action.do" method="post">
<%
Integer id = (Integer)request.getSession().getAttribute("rest_id");
Map<Integer, Set<Integer>> data = (Map<Integer, Set<Integer>>)getServletContext().getAttribute("table_data");
Set<Integer> freeTables = data.get(id);
for(int i:freeTables){
%>
<h2>
<input type="radio" name="number" value="<%=i%>"/>Table Number <%=i%>
<br>
<%
}
%>
</h2>
<br>
<input type="submit" id="submit" name="selectTables" value="Select Tables"></input>
</form> 
</body>
</html>