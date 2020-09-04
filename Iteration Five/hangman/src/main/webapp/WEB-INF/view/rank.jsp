<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:wrapper>
	<body class="text-center" data-gr-c-s-loaded="true">
		<form method="get">
			<nav class="navbar navbar-expand-sm bg-light navbar-light">
				<div>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="/hangman/rank/topTen">Top10</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/hangman/rank/topMonth">Month Rank</a></li>
					</ul>
				</div>
			</nav>
		</form>
		<a class="btn btn-lg btn-secondary" href="/hangman">Back</a>
	</body>
</t:wrapper>