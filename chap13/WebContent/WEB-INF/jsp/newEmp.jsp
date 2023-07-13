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
			<h1>新規社員登録</h1>
			<c:if test="${not empty errmsgList}" >
				<ul>
					<c:forEach var="errmsg" items="${errmsgList}">
						<li><c:out value="${errmsg}" /></li>
					</c:forEach>
				</ul>
			</c:if>
			<form method="post" action="${pageContext.request.contextPath}/new">
				<table>
					<tr>
						<th>ID</th>
						<th>名前</th>
						<th>年齢</th>
					</tr>
					<tr>
						<td><input type="text" name="id" placeholder="EMP000" value='<c:out value="${emp.id}" />'></td>
						<td><input type="text" name="name"  value='<c:out value="${emp.name}" />'></td>
						<td><input type="text" name="age"  value='<c:out value="${ (_age != null ) ? _age : emp.age  }" />'></td>
					</tr>
				</table>
				<div id="table-footer">
					<input class="table-footer-btn table-footer-btn-txt" type="submit" value="登 録">
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