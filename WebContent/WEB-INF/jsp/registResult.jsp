<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="app.logic.User"%>
<%
	boolean result = (boolean) session.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トークアプリ</title>
</head>
<body>
	<h1>ユーザー登録</h1>
	<%
		if (result) {
	%>
	<p>ユーザー登録に成功しました</p>
	<%
		} else {
	%>
	<p>ユーザー登録に失敗しました</p>
	<%
		}
	%>
	<a href="<%=request.getContextPath()%>/ManageServlet">戻る</a><br>
	<a href="<%=request.getContextPath()%>/">TOPへ</a>
</body>
</html>