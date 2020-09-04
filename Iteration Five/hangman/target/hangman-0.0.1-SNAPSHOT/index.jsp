<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<style><%@include file="/WEB-INF/css/link.css"%></style>
<t:wrapper>
<body>
	<h1>
		<c:set var = "title" value="Welcome to my Hangman game!"/>
		<c:out value="${title}"/>
	</h1>
	<hr/>
	<c:set var="new" scope="application" value="New game"/>
	<a href="new">New Game</a>
</body>
</t:wrapper>
