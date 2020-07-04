<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
    
<t:wrapper>
<body>
<h2>Hangman Game</h2>
<form action="newGame" method="post">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<h2>You lose!</h2>
		<h2>The word was: ${theWord}</h2>
		<br/>
		<c:set var="new" scope="application" value="New game"/>
		<button class="btn btn-lg btn-secondary" type="submit">New Game</button>
		<br/>
		<br/>
		<a class="btn btn-lg btn-secondary" href="/hangman">Back</a>
		</div>
</form>
</body>
</t:wrapper>