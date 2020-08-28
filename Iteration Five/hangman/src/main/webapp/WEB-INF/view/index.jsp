<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:wrapper>
	<body class="text-center" data-gr-c-s-loaded="true">
		<form method="post">
			<div>
				<div
					class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
					<h1>
						<c:set var="title" value="Welcome to my Hangman game!" />
						<c:out value="${title}" />
					</h1>
					<hr />
					<label for="nameImput">Enter username: <input type="text"
						id="usernameInput" name="username">
					</label>
					<c:set var="new" scope="application" value="New game" />
					<button id="buttonGame" class="btn btn-lg btn-secondary"
						type="submit">New Game</button>
						<br>
						<br>
					<a class="btn btn-lg btn-secondary" href="/hangman/rank">Rank</a>
					<br/>
					<a class="btn btn-lg btn-secondary" href="/hangman/word/page/1">Words</a>
				</div>
			</div>
		</form>
	</body>
</t:wrapper>
