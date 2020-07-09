<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:wrapper>
<body>
<form method="post">
<div class="cover-container d-flex w-100 h-50 p-3 mx-auto flex-column">
<h2 id="titleId" align="center">Hangman Game</h2>
<br/>
<h3 align="center">${hiddenWord}</h3>
<h3 id="secret" hidden="true" align="center">${word}</h3>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
	    <h3>Used letters: ${allLetters}</h3>
	    <h3>Number tries remaining: ${tries}</h3>
	<t:keyboard/>
<br/>
<br/>
</div>
</form>
<div class="cover-container w-10 h-50 p-3 mx-auto flex-column">
<a id="backHome" class="btn btn-lg btn-secondary" href="/hangman">Back</a>
</div>
</body>
</t:wrapper>


