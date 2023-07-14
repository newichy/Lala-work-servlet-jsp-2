<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%@ include file="./common/head.jsp" %>
<body>
	<%@ include file="./common/header.jsp"%>
	<main>
		<article>
			<h1>このレコードを削除しますか？</h1>
				<table>
					<tr>
						<th>ID</th>
						<th>名前</th>
						<th>年齢</th>
					</tr>
					<tr>
						<td><c:out value="${ emp.id }" /></td>
						<td><c:out value="${ emp.name }" /></td>
						<td><c:out value="${ emp.age }" /></td>
					</tr>
				</table>
				<div id="table-footer">
				<form method="post" action="${pageContext.request.contextPath}/remove">
					<input type="hidden" value="${ emp.id }" name="id">
					<input class="table-footer-btn table-footer-btn-txt red" type="submit" value="削 除">
					<button class="table-footer-btn table-footer-btn-txt">
						<a href="${pageContext.request.contextPath}/list">取 消</a>
					</button>
				</form>
					
				</div>
		</article>
		<%@ include file="./common/aside.jsp"%>
	</main>
	<%@ include file="./common/footer.jsp"%>
</body>
</html>