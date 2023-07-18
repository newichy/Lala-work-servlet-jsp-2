<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./common/directive.jsp" %>

<!DOCTYPE html>
<html>
<%@ include file="./common/head.jsp" %>
<body>
	<%@ include file="./common/header.jsp"%>
	<main>
		<article>
			<h1>社員一覧</h1>
			<table>
				<tr>
					<th>ＩＤ</th>
					<th>名前</th>
					<th>年齢</th>
					<th>所属</th>
					<th	class="table-tool"></th>
					<th class="table-tool"></th>
				</tr>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td><c:out value="${emp.id}" /></td>
						<td><c:out value="${emp.name}" /></td>
						<td><c:out value="${emp.age}" /></td>
						<td><c:out value="${emp.dept.name}" /></td>
						<td class="table-tool">
							<form action="${pageContext.request.contextPath}/update" method="post">
								<input type="hidden" name="id" value="${emp.id}">
							<%-- <input class="table-tool-txt" type="submit" value="編集">	--%>
								<button class="table-tool-txt" type="submit">${Const.IMG_PENCIL}</button>
							</form>
						</td>
						<td class="table-tool">
							<form action="${pageContext.request.contextPath}/delete" method="post">
								<input type="hidden" name="id" value="${emp.id}">
							<%-- <input class="table-tool-txt" type="submit" value="削除">	--%>
								<button class="table-tool-txt" type="submit">${Const.IMG_TRASH}</button>
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