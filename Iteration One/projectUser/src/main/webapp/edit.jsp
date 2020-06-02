<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map" %>
<%@page import="model.User" %>
<%@page import="web.EditServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int k;
if(request.getParameter("key") == null){
  k = 0;
}else{
  k = Integer.parseInt(request.getParameter("key"));
}

String username = ((Map<String, User>) request.getServletContext().getAttribute("users")).get(k).getUsername();

%>
<h1>${edit} - <%= username %></h1>
<%
User user = ((Map<String, User>) request.getServletContext().getAttribute("users")).get(k);
%>
	<form method="post">
		<label for="nameImput">Name:
	        <input type="text" value=<%= user.getName() %> id="nameImput" name="name">
	    </label>
	    <br/>
	    <label for="usernameInput">Username:
	        <input type="text" value=<%= user.getUsername() %> id="usernameInput" name="username">
	    </label>
	    <br/>
	    <label for="passwordInput">Password:
	        <input type="password" value=<%= user.getPassword() %> id="passwordInput" name="password">
	    </label>
	    <br/>
	    <button type="submit">Edit User</button>
	
	</form>
	<br/>
<a href="all.jsp">Back</a>
</body>
</html>