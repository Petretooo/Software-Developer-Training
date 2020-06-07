<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${create}"/></h1>
	<form action="create" method="post">
		<label for="nameImput">Name:
	        <input type="text" id="nameImput" name="name">
	    </label>
	    <br/>
	    <label for="usernameInput">Username:
	        <input type=text id="usernameInput" name="username">
	    </label>
	    <br/>
	    <label for="passwordInput">Password:
	        <input type="password" id="passwordInput" name="password">
	    </label>
	    <br/>
	    <button type="submit">Create User</button>
	
	</form>
	<br/>
<a href="index">Back</a>
</body>
<footer>
<t:wrapper/>
</footer>
</html>