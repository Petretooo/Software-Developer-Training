<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
<body >
	<h1 align="center">
		<c:set var = "title" value="Welcome to my simple User CRUD application"/>
		<c:out value="${title}"/>
	</h1>
	<hr/>
	<c:set var="create" scope="application" value="Create User"/>
	<a href="create">Create User</a>
	<br/>
	<c:set var="all" scope="application" value="All Users"/>
	<a href="all">All users</a>
</body>
</t:wrapper>
