<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is my way!</h1>
	<h1>
		<%=getServletConfig().getInitParameter("greet")+" "+ request.getParameter("name")%>
	</h1>
	<h3>

	</h3>
</body>
</html>