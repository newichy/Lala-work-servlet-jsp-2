<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<%@ include file="../common/head.jsp" %>
<body>
	<%@ include file="../common/header.jsp" %>
	<main class="main">
		<article class="confirm">
			<h1>社員情報更新確認</h1>
			<form method="post" 
			      action="${pageContext.request.contextPath}/updateDeptDone">
				<table>
					<tr>
						<th>ID</th>
						<td><c:out value="${dept.id}" /></td>
					</tr>
					<tr>
						<th>名前</th>
						<td><c:out value="${dept.name}" /></td>
					</tr>
				</table>
				<input type="hidden" name="id" value="${dept.id}">
				<input type="hidden" name="name" value="${dept.name}">
				<input type="submit" value="更新">
				<a href="${pageContext.request.contextPath}/deptList">
				  <button type="button">取消</button></a>
			</form>
		</article>
		<%@ include file="../common/aside.jsp" %>	
	</main>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>