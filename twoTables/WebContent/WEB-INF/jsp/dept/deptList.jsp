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
			<h1>部署一覧</h1>
			<table>
				<tr>
					<th>ＩＤ</th>
					<th>部署名</th>
					<th	class="table-tool"></th>
					<th class="table-tool"></th>
				</tr>
				<c:forEach var="dept" items="${deptList}">
					<tr>
						<td><c:out value="${dept.id}" /></td>
						<td><c:out value="${dept.name}" /></td>
						<td class="table-tool">
							<form action="${pageContext.request.contextPath}/deptUpdate" method="post">
								<input type="hidden" name="id" value="${dept.id}">
								<button class="table-tool-txt" type="submit">${Const.IMG_PENCIL}</button>
							</form>
						</td>
						<td class="table-tool">
							<form action="${pageContext.request.contextPath}/deptDelete" method="post">
								<input type="hidden" name="id" value="${dept.id}">
								<button class="table-tool-txt" type="submit">${Const.IMG_TRASH}</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</article>
		<%@ include file="../common/aside.jsp"%>
	</main>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>