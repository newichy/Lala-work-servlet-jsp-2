<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="./common/header.jsp"%>
	<main>
		<article>
			<h1>社員一覧</h1>
			<table>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>年齢</th>
					<th	class="table-tool"></th>
					<th class="table-tool"></th>
				</tr>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td><c:out value="${emp.id}" /></td>
						<td><c:out value="${emp.name}" /></td>
						<td><c:out value="${emp.age}" /></td>
						<td class="table-tool">
							<form action="${pageContext.request.contextPath}/update" method="post">
								<input type="hidden" name="id" value="${emp.id}">
								<input class="table-tool-txt" type="submit" value="編集">
							</form>
						</td>
						<td class="table-tool">
							<form action="${pageContext.request.contextPath}/delete" method="post">
								<input type="hidden" name="id" value="${emp.id}">
								<input class="table-tool-txt" type="submit" value="削除">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</article>
		<%@ include file="./common/aside.jsp"%>
	</main>
	<%@ include file="./common/footer.jsp"%>
</body>
</html>