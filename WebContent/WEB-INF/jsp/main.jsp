<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="app.logic.User,app.logic.Mutter,java.util.List"%>
<%
	User loginUser = (User) session.getAttribute("loginUser");
	List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList");
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トークアプリ</title>
<style>
#mutter {
	padding: 0px 10px;
}
</style>
</head>
<body>
	<h1>トークアプリ</h1>
	<%
		if (errorMsg != null) {
	%>
	<p>
		<font color="red"><%=errorMsg%></font>
	</p>
	<%
		}
	%>
	<p>
		<%=loginUser.getName()%>さん、ログイン中 <a href="<%=request.getContextPath()%>/LogoutServlet">ログアウト</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/MainServlet">更新</a>
	</p>
	<form action="<%=request.getContextPath()%>/MainServlet" method="post">
		<input type="text" name="text"> <input type="submit"
			value="つぶやく">
	</form>
	<form action="<%=request.getContextPath()%>/DeleteServlet" method="post">
		<input type="submit" value="削除">
		<table>
			<%
				int i = 0;
			%>
			<%
				for (Mutter mutter : mutterList) {
			%>
			<tr>
				<td>
					<input type="radio" name="radio" value=<%=i%>>
					<input type="hidden" name="name<%=i%>" value=<%=mutter.getUserName()%>>
					<input type="hidden" name="text<%=i%>" value=<%=mutter.getText()%>>
					<input type="hidden" name="time<%=i%>" value=<%=mutter.getTime()%>>
				</td>
				<td>
					[<%=mutter.getUserName()%>]
				</td>
				<td>
					<a id="mutter"><%=mutter.getText()%></a>
				</td>
				<td>
					(<%=mutter.getTime()%>)
				</td>
			</tr>
			<%
				i++;
			%>
			<%
				}
			%>
		</table>
	</form>
</body>
</html>