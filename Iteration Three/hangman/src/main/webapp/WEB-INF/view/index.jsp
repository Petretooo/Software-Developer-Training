<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<t:wrapper>
<body class="text-center" data-gr-c-s-loaded="true">
<form action="newGame" method="post">
<div style="background-image: url('hangmanImg.jpg')">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
	<h1>
		<c:set var = "title" value="Welcome to my Hangman game!"/>
		<c:out value="${title}"/>
	</h1>
	<hr/>
	<c:set var="new" scope="application" value="New game"/>
	<button class="btn btn-lg btn-secondary" type="submit">New Game</button>
</div>
</div>
</form>
</body>
</t:wrapper>
