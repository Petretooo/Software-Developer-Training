<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%
	int currentPage = (int) request.getAttribute("currentPage");
%>
<t:wrapper>
	<body class="text-center" data-gr-c-s-loaded="true">
		<form method="post" action="/hangman/words?page=${1}">
			<label for="wordnameImput">Enter word: <input type="text"
				id="wordNameInput" name="wordName">
			</label> <label for="levelImput">Level of Difficulty: <input
				type="text" id="levelInput" name="level">
			</label>
			<button id="addWord" class="btn btn-lg btn-secondary" type="submit">Add
				Word</button>
			<h1>
				<c:out value="${all}" />
			</h1>
			<div class="row justify-content-center">
				<div class="col-auto">
					<table class="table table-striped table-hover">
						<thead class="thead-light">
							<tr>
								<th>Word</th>
								<th>Level</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="words" items="${show}">
								<tr>
									<td>${words.getWordName()}</td>
									<td>${words.getLevelDifficulty()}</td>
									<td><a
										href="${pageContext.request.contextPath}/words/${words.getWordName()}"
										onclick="return confirm('Are you sure?')">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<nav aria-label="...">
						<ul class="pagination pagination-lg">
							<c:forEach var="pageNumber" begin="1" end="${pages}">
								<c:choose>
									<c:when test="${currentPage == pageNumber}">
										<li class="page-item active"><a class="page-link"
											href="/hangman/words?page=${pageNumber}">${pageNumber}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/hangman/words?page=${pageNumber}">${pageNumber}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</nav>
				</div>
			</div>
		</form>
		<a class="btn btn-lg btn-secondary" href="/hangman">Back</a>
	</body>
</t:wrapper>