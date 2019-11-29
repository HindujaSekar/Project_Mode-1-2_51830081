<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Account</title>
</head>
<body>
<form:form action="addaccount" method="post" modelAttribute="accountform">
	Enter Deposit Initial Balance:<form:input path="balance"/><br/>
	Enter Customer Details:<br/><br/>
	Enter Customer Name:<form:input path="name"/><br/>
	Enter Customer Email:<form:input path="email"/><br/>
	Enter Customer Phone:<form:input path="phone"/><br/>
	Enter Customer Address:<form:input path="address"/><br/>
	Enter Customer City:<form:input path="city"/><br/>
	Enter Customer Country:<form:input path="country"/><br/>
	<br/><br/>
	Enter BlockedStatus: <form:input path="blocked"/><br/>
	<input type="submit"/>

</form:form>
</body>
</html>