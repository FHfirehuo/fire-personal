<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Hello World</title>
<%@ include file="common/common.jsp" %>
</head>

<body>
	<div class="container">
		<h1>This is secured!</h1>
		<p>
			Hello <b></b>
		</p>
		<form class="form-inline" action="logout" method="post">
			<input type="submit" value="Log out" /> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>

</body>
	</html>

