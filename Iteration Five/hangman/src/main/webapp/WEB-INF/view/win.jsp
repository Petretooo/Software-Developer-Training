<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper>
	<body class="text-center" data-gr-c-s-loaded="true">
		<h2>Hangman Game</h2>
		<form method="post" action="/hangman/win">
			<div
				class="cover-container d-flex w-100 h-30 p-3 mx-auto flex-column">
				<h1>You win!</h1>
				<h2>${theWord}</h2>
				<br /> <label for="nameImput">Enter username: <input
					type="text" id="usernameInput" name="username">
				</label>
				<c:set var="new" scope="application" value="New game" />
				<button class="btn btn-lg btn-secondary" type="submit">New
					Game</button>
				<br /> <br />
				<input hidden="true" value="/win" name="errorPage">
			</div>
		</form>
		<a class="btn btn-lg btn-secondary" href="/hangman">Back</a>
	</body>
</t:wrapper>