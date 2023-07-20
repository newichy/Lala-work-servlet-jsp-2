<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/directive.jsp" %>
<!DOCTYPE html>
<html>
<%@ include file="../common/head.jsp" %>
<body>
	<%@ include file="../common/header.jsp"%>
	<main>
		<article>
			<h1>この情報で登録しますか？</h1>
			<form method="post" action="${pageContext.request.contextPath}/registDept">
				<table>
					<tr>
						<th>ID</th>
						<th>部署名</th>
					</tr>
					<tr>
						<td><input class="confirm" type="text" name="id" value="<c:out value="${ dept.id }" />"></td>
						<td><input class="confirm" type="text" name="name"  value="<c:out value="${ dept.name }" />"></td>
					</tr>
				</table>
				<div id="table-footer">
					<input class="table-footer-btn table-footer-btn-txt red" type="submit" value="確 定">
					<button class="table-footer-btn table-footer-btn-txt">
						<a href="${pageContext.request.contextPath}/deptList">取 消</a>
					</button>
				</div>
			</form>
		</article>
		<%@ include file="../common/aside.jsp"%>
	</main>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>