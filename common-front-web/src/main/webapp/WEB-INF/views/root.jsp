<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dev - heros</title>
</head>
<body>
	<p>
		<a
			href="<spring:url htmlEscape="true" value="http://localhost:8080/HERO/005/heros/orders.html"/>">lien
			heros</a>
	</p>

	<h3>api</h3>
	<p>
		<a
			href="<spring:url htmlEscape="true" value="http://localhost:8082/swagger-ui.html"/>">
			api heros </a>
	</p>
</body>
</html>