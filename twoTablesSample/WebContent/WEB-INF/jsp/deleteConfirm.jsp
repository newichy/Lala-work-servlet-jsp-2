<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<%@ include file="./common/head.jsp" %>
<body>
	<%@ include file="./common/header.jsp" %>
	<main class="main">
		<article class="confirm">
			<h1>削除確認</h1>
			<p>以下のデータを削除します。</p>
			<table>
				<tr>
					<th>ID</th>
					<td><c:out value="${employee.id}" /></td>
				</tr>
				<tr>
					<th>名前</th>
					<td><c:out value="${employee.name}" /></td>
				</tr>
				<tr>
					<th>年齢</th>
					<td><c:out value="${employee.age}" /></td>
				</tr>
				<tr>
					<th>部署</th>
					<td><c:out value="${employee.dept.name}" /></td>
				</tr>
			</table>
			<form method="post" 
			      action="${pageContext.request.contextPath}/deleteDone">
			  <input type="hidden" name="id" value="${employee.id}">
				<input type="submit" value="削除">
				<a href="${pageContext.request.contextPath}/list">
				  <button type="button">取消</button></a>
			</form>
		</article>
		<%@ include file="./common/aside.jsp" %>	
	</main>
	<%@ include file="./common/footer.jsp" %>
</body>
</html>