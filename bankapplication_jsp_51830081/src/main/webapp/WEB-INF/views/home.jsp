<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Application</title>
</head>
<body>
${info }<br/>
	<sec:authorize access="hasAnyRole('ADMIN')">
		<li><a href="admin/usermgt">user management</a>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ADMIN','MGR','CLERK')">
		<li><a href="clerk/accmgt">account management</a>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ADMIN','MGR','CLERK')">
		<li><a href="logout">logout</a>
	</sec:authorize>


</body>
</html>