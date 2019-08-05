<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トークアプリ</title>
</head>
<body>
	<h1>トークアプリへログイン</h1>
	<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
		ユーザー名：<input type="text" name="name"> <br>
		パスワード：<input type="password" name="pass"> <br>
		<input type="submit" value="ログイン">
	</form>
	<a href="<%=request.getContextPath()%>/ManageServlet">ユーザー管理</a>
</body>
</html>