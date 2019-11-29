<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AllUserDetails</title>
</head>
<body>
<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<th>phone</th>
				<th>address</th>
				<th>roles</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.phone}</td>
				<td>${user.address}</td>
				<td>
				<c:forEach var="temp" items="${user.roles}">
					<c:out value="${temp }"></c:out>
				</c:forEach></td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>