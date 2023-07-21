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
			<h1>社員情報更新確認</h1>
			<form method="post" 
			      action="${pageContext.request.contextPath}/updateDone">
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
						<td>
							<c:forEach var="dept" items="${deptList}">
								${dept.id == employee.dept.id ? dept.name : ''}
							</c:forEach>
						</td>
					</tr>
				</table>
				<input type="hidden" name="id" value="${employee.id}">
				<input type="hidden" name="name" value="${employee.name}">
				<input type="hidden" name="age" value="${employee.age}">
				<input type="hidden" name="dept_id" value="${employee.dept.id}">
				<input type="submit" value="更新">
				<a href="${pageContext.request.contextPath}/list">
				  <button type="button">取消</button></a>
			</form>
		</article>
		<%@ include file="./common/aside.jsp" %>	
	</main>
	<%@ include file="./common/footer.jsp" %>
</body>
</html>