<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:wrapper>
	<body>
		<form method="get">
			<h1>
				<c:out value="${all}" />
			</h1>
			<div class="row justify-content-center">
				<div class="col-auto">
					<table class="table table-responsive">
						<thead class="thead-light">
							<tr>
								<th>Username</th>
								<th>Word</th>
								<th>Score</th>
								<th>Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="rank" items="${show}">
								<tr>
									<td>${rank.getUser().getUsername()}</td>
									<td>${rank.getWord()}</td>
									<td>${rank.getScore()}</td>
									<td>${rank.getDate().toString()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</form>
		<a class="btn btn-lg btn-secondary" href="/hangman/rank">Back</a>
	</body>
</t:wrapper>