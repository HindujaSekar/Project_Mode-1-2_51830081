<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GiveTime</title>
</head>
<body>
	<form:form action="transaction"  method="post" modelAttribute="timeforms">
	 Enter From time: <form:input path="fromTime" type="datetime-local" />
	 Enter To time: <form:input path="toTime" type="datetime-local" />
	 <input type="submit"/>
	</form:form>
</body>
</html>