<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<style><%@include file="/WEB-INF/css/link.css"%></style>
    
<t:wrapper>
<body>
<h2>Hangman Game</h2>
<form action="newGame" method="post">
		<h1>You win!</h1>
		<h2>${theWord}</h2>
</form>
<br/>
<a href="new">New Game</a>
<a href="index">Back</a>
</body>
</t:wrapper>