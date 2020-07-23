<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
    
<t:wrapper>
<body class="text-center" data-gr-c-s-loaded="true">
<h2>Hangman Game</h2>
<form action="/hangman/games" method="post">
<div class="cover-container d-flex w-100 h-30 p-3 mx-auto flex-column">
		<h2>You lose!</h2>
		<h2>The word was: ${theWord}</h2>
		<br/>
		<button class="btn btn-lg btn-secondary" type="submit">New Game</button>
		<br/>
		<br/>
		</div>
</form>
		<a class="btn btn-lg btn-secondary" href="/hangman">Back</a>
</body>
</t:wrapper>