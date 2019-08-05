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
<title>トークアプリ</title>
</head>
<body>
	<h1>ログイン</h1>
	<%
		if (loginUser != null) {
	%>
	<p>ログインに成功しました</p>
	<p>
		ようこそ！<%=loginUser.getName()%>さん
	</p>
	<a href="<%=request.getContextPath()%>/MainServlet">つぶやき投稿・閲覧へ</a>
	<%
		} else {
	%>
	<p>ログインに失敗しました</p>
	<a href="<%=request.getContextPath()%>/">TOPへ</a>
	<%
		}
	%>
</body>
</html>