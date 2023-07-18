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
			<h1>社員情報編集確認</h1>
			<c:if test="${not empty errmsgList}" >
				<ul>
					<c:forEach var="errmsg" items="${errmsgList}">
						<li><c:out value="${errmsg}" /></li>
					</c:forEach>
				</ul>
			</c:if>
			<form method="post" action="${pageContext.request.contextPath}/updateDone">
				<table>
					<tr>
						<th>ID</th>
						<th>名前</th>
						<th>年齢</th>
					</tr>
					<tr>
						<td><c:out value="${ emp.id }" /></td>
						<td><input class="confirm" type="text" name="name"  value='<c:out value="${ emp.name }" />'></td>
						<td><input class="confirm" type="text" name="age"  value='<c:out value="${ (_age != null ) ? _age : emp.age  }" />'></td>
					</tr>
				</table>
				<input type="hidden" name="id"  value='<c:out value="${ emp.id }" />'>
				<div id="table-footer">
					<input class="table-footer-btn table-footer-btn-txt" type="submit" value="確 定">
					<button class="table-footer-btn table-footer-btn-txt">
						<a href="${pageContext.request.contextPath}/list">取 消</a>
					</button>
				</div>
			</form>
		</article>
		<%@ include file="./common/aside.jsp"%>
	</main>
	<%@ include file="./common/footer.jsp"%>
</body>
</html>