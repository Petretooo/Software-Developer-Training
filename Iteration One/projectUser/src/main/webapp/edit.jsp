<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map" %>
<%@page import="model.User" %>
<%@page import="web.EditServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<style><%@include file="/WEB-INF/css/create-edit.css"%></style>
<style><%@include file="/WEB-INF/css/link.css"%></style>
<t:wrapper>
<body>
<h1>${edit}-${username}</h1>
	<form method="post">
		<label for="nameImput">Name:
	        <input type="text" value=${name} id="nameImput" name="name">
	    </label>
	    <br/>
	    <label for="usernameInput">Username:
	        <input type="text" value=${username} id="usernameInput" name="username">
	    </label>
	    <br/>
	    <label for="passwordInput">Password:
	        <input type="password" value=${password} id="passwordInput" name="password">
	    </label>
	    <br/>
	    <button type="submit">Edit User</button>
	
	</form>
	<br/>
<a href="all">Back</a>
</body>
</t:wrapper>