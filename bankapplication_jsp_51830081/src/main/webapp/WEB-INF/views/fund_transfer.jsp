<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fund transfer</title>
<style type="text/css">
	.error{
		color: red
	}
</style>
</head>
<body>
<form:form action="transfer" method="post" modelAttribute="fundForm">
	Enter from Account : <form:input path="fromAccount"/><form:errors path="fromAccount" class="error"/><br/>
	Enter to Account : <form:input path="toAccount"/><form:errors path="toAccount" class="error"/><br/>
	Enter Amount to transfer : <form:input path="amount"/><form:errors path="amount" class="error"/><br/>
	<input type="submit">
</form:form>
</body>
</html>

