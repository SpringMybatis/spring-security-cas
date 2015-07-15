<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<h3><a href="admin.jsp">admin</a><br></h3>
	<h3><a href="manager.jsp">manager</a><br></h3>
	<h3><a href="common.jsp">common</a><br></h3>
	<form action="j_spring_security_logout" method="post">
		<input type="submit" value="登出" />
	</form>
</body>
</html>