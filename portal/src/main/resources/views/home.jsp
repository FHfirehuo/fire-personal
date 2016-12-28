<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="common/common.jsp" %>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>This is secured!</h1>
		<p>
		</p>
		<form class="form-inline" action="${APP_CTX }logout" method="post">
			<input type="submit" value="Log out" /> 

		</form>
	</div>
</body>
</html>