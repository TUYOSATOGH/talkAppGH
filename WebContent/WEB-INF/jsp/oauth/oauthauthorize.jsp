<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="app.logic.User"%>
<%
	User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OAuth認証</title>
</head>
<body>
	<h1>トークアプリ</h1>
	<p>
		<%=loginUser.getName()%>さんでOAuth認証をします
	</p>
	<form action="<%=request.getContextPath()%>/OAuthAuthorizeServlet" method="post">
	<input type="submit" value="認可">
	</form>
	<form action="<%=request.getContextPath()%>/OAuthAuthorizeServlet" method="get">
		<input type="submit" value="中止">
	</form>
</body>
</html>