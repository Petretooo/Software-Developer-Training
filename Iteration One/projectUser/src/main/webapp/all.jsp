<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map" %>
<%@page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
<body>
<h3>${hello}</h3>
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
		<c:forEach var="user" items="${show}">
		<tr>
			<td>${user.getKey()}</td>
			<td>${user.getValue().getName()}</td>
			<td>${user.getValue().getUsername()}</td>
			<td>${user.getValue().getPassword()}</td>
			<td>
			<a href="delete?key=${user.getKey()}">Delete</a>
			<c:set var="edit" scope="application" value="Edit User"/>
			<a href="edit?key=${user.getKey()}">Edit</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<a href="index">Back</a>
</body>
</t:wrapper>
