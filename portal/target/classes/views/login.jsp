<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <%@ include file="common/common.jsp" %>
<title>哈哈哈</title>
</head>
<body>
	<div>
		<form action="login" method="post"  >
			<fieldset>
				<legend>Please Login</legend>

				<label for="username">Username</label> 
				<input type="text"id="username" name="username" value="user" /> 
				<label for="password">Password</label> 
				<input type="password" id="password" name="password" value="password" />
				<div class="form-actions">
					<button type="submit" class="btn">Log in</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>