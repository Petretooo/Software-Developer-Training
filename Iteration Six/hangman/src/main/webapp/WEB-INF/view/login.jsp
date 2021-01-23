<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper>
<body>
	<form method="post" class="html">
		<div class="container">
			<h1>Log In</h1>
			
			<label for="username"><b>Username</b></label> 
			<input type="text"placeholder="Enter Username" name="username" id="username" required/> 
			
			<label for="password"><b>Password</b></label> 
			<input type="password"placeholder="Enter Password" name="password" id="password" required />
			
			<hr />
			
			<button className="btn btn-lg btn-secondary" type="submit" value="Submit">
              Log In
            </button>
			
			<br /> 
			<br /> 
			<a className="btn btn-lg btn-secondary"
				href="/hangman"> Back </a>
				<br/>
			<a className="btn btn-lg btn-secondary"
				href="/hangman/registration"> Registration </a>
		</div>
	</form>
</body>
</t:wrapper>