<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
<%@ page import="model.User" %>
<%@ page import="model.Mutter" %>
<%@ page import="java.util.List" %>
<% 
	User loginUser = (User) session.getAttribute("loginUser");
	List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
 --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
	<h1>どこつぶメイン</h1>
	<p>	
		<%-- <%= loginUser.getName() %> --%>
		<c:out value="${ loginUser.name }" />さん、ログイン中です。
		<a href="/docoTsubu_JSTL/Logout">ログアウト</a>
	</p>
	<p><a href="/docoTsubu_JSTL/Main">更新</a></p>
	<form action="/docoTsubu_JSTL/Main" method="post">
		<input type="text" name="text">
		<input type="submit" value="つぶやく">
	</form>
	<%--
	<% if(errorMsg != null){
		<P style="color:red;"><%= errorMsg %></P>
	<% } %>
	--%>
	<c:if test="${not empty errorMsg}">
		<P>${errorMsg}</P>
	</c:if>
	
	<%-- 
	<% for(Mutter mutter : mutterList){ %>
		<P><%= mutter.getUserName() %>:<%= mutter.getText() %></P>
	<% } %>
	--%>
	<c:forEach var="mutter" items="${mutterList}">
		<P>
			<c:out value="${mutter.userName}" />:<c:out value="${mutter.text}" />
		</P>
	</c:forEach>
</body>
</html>