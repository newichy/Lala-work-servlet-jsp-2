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
			<h1>新規社員登録</h1>
			<c:if test="${not empty errmsgList}" >
				<ul>
					<c:forEach var="errmsg" items="${errmsgList}">
						<li><c:out value="${errmsg}" /></li>
					</c:forEach>
				</ul>
			</c:if>
			<form method="post" action="${pageContext.request.contextPath}/newDept">
				<table>
					<tr>
						<th>ID</th>
						<th>部署名</th>
					</tr>
					<tr>
						<td><input type="text" name="id" placeholder="D00" value='<c:out value="${dept.id}" />'></td>
						<td><input type="text" name="name"  value='<c:out value="${dept.name}" />'></td>
					</tr>
				</table>
				<div id="table-footer">
					<input class="table-footer-btn table-footer-btn-txt" type="submit" value="登 録">
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