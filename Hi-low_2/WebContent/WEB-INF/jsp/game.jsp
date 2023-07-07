<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	
	<main>
		<p>１～９９の数字を入力</p>
		<form action="/Hi-low_2/game" method="post">
			<input type="text" name="num"><br>
			<input type="submit" value="送信">
		</form>
		<p>${ msg }</p>
		<p><a href="/Hi-low_2/game">数字を再設定</a></p>
	</main>
	
	<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>