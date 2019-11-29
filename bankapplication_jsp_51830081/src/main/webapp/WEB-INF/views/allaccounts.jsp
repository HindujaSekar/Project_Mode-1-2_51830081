<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AllAccountDetails</title>
</head>
<body>
<table border="1">
		<thead>
			<tr>
				<th>accountNumber</th>
				<th>balance</th>
				<th>customerName</th>
				<th>address</th>
				<th>E-mail</th>
				<th>contact</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts }" var="account">
			<tr>
				<td>${account.accountNumber}</td>
				<td>${account.balance}</td>
				<td>${account.customer.name}</td>
				<td>${account.customer.address}</td>
				<td>${account.customer.email}</td>
				<td>${account.customer.phone}</td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>