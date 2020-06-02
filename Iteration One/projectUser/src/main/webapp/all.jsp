<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map" %>
<%@page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1><c:out value="${all}"/></h1>
	<table border="1">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Username</th>
			<th>Password</th>
		</tr>
	</thead>
	<tbody>
		<%
		
		Map<Integer, User> users = (Map<Integer, User>) request.getServletContext().getAttribute("users");
		
		%>
		<%
			for (Map.Entry<Integer, User> entry : users.entrySet()){
		
		%>
		<tr>
			<td><%=entry.getKey()%></td>
			<td><%=entry.getValue().getName()%></td>
			<td><%=entry.getValue().getUsername() %></td>
			<td><%=entry.getValue().getPassword() %></td>
			<td>
			<a href="delete?key=<%=entry.getKey()%>">Delete</a>
			<c:set var="edit" scope="application" value="Edit User"/>
			<a href="edit?key=<%=entry.getKey()%>">Edit</a>
			</td>
		</tr>
		<%
			}
		%>
	
	</tbody>
</table>
<a href="index">Back</a>
</body>
</html>