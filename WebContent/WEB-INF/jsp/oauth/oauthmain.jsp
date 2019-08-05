<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OAuth認証</title>
</head>
<body>
	<h1>OAuth認証</h1>
	<form action="<%=request.getContextPath()%>/OAuthLoginServlet" method="post">
		ユーザー名：<input type="text" name="name"> <br>
		パスワード：<input type="password" name="pass"> <br>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>