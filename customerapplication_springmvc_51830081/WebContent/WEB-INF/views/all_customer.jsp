<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer detail</title>
</head>
<body>
	welcome ${user.name }
	<br />
	<a href="logout">logout</a>
	<br />
	<br />
	<br />
	<div class="container">
		<div class="row">
			<div class="col-sm-6">

				<table border="1">
					<thead>
						<tr>
							<th>id</th>
							<th>name</th>
							<th>address</th>
							<th>city</th>
							<th>companyname</th>
							<th>phone</th>
							<th>email</th>
							<th>update</th>
							<th>delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${customers}" var="customer">
							<tr>
								<td>${customer.id}</td>
								<td>${customer.name}</td>
								<td>${customer.address}</td>
								<td>${customer.city}</td>
								<td>${customer.companyname}</td>
								<td>${customer.phone}</td>
								<td>${customer.email}</td>
								<td><a href="update?id=${customer.id}">update</a></td>
								<td><a href="delete?id=${customer.id}">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
				</div></div>


				<a href="addcustomer">add customer</a>
</body>
</html>