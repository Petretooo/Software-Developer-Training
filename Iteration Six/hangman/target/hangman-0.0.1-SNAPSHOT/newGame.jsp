<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<style><%@include file="/WEB-INF/css/link.css"%></style>

<t:wrapper>
<body>
<h2>Hangman Game</h2>
<h3>${hiddenWord}</h3>
<form method="post">
		<label for="nameImput">Enter a letter:
	        <input type="text" id="letterImput" name="letter">
	    </label>
	    <h3>Used letters: ${allLetters}</h3>
	    <h3>Number tries remaining: ${tries}</h3>
	    <button type="submit">Enter</button>
</form>
<br/>
<a href="index">Back</a>
</body>
</t:wrapper>