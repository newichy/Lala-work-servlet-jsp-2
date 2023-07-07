<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
<%@ page import="ex.Fruit"
<% Fruit fruit = (Fruit)application.getAttribute("fruit"); %>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	<%--
	<%= fruit.getName() %>の値段は<%= fruit.getPrice() %>円です。
	--%>
	${applicationScope.fruit.name}の値段は${applicationScope.fruit.price}円です。
	</p>


</body>
</html>