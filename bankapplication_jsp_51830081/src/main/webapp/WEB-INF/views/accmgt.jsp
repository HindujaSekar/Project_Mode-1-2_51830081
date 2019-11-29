<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AccountManagement</title>
</head>
<body>
	<sec:authorize access="hasAnyRole('ADMIN','MGR','CLERK')">
		<li><a href="allaccount">view_All_Accounts</a><br/></li>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ADMIN','MGR')">
		<li><a href="transfer">transfer_fund</a><br/></li>
		<li><a href="withdraw">withdraw_fund</a><br/> </li>
		<li><a href="deposit">deposit_fund</a><br/></li>
	</sec:authorize>
</body>
</html>