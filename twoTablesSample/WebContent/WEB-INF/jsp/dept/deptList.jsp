<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.Const" %>
<!DOCTYPE html>
<html>
	<%@ include file="../common/head.jsp" %>
<body>
	<%@ include file="../common/header.jsp" %>
	<main class="main">
		<article>
			<h1>部署一覧</h1>
			<table>
				<tr>
					<th>ID</th>
					<th>部署名</th>
					<th class="no-border"></th>
					<th class="no-border"></th>
				</tr>
				<c:forEach var="dept" items="${deptList}">
					<tr>
						<td><c:out value="${dept.id}" /></td>
						<td><c:out value="${dept.name}" /></td>
						<!-- ============================================== -->
						<td style="border:none">
						  <form action="${pageContext.request.contextPath}/updateDept" method="post">
						    <input type="hidden" name="id" value="${dept.id}">
							  <button class="no-btn" type="submit">${Const.IMG_PENCIL}</button>
						  </form>
						</td>
						<!-- ============================================== -->
						<td style="border:none">
						  <form action="${pageContext.request.contextPath}/deleteDept" method="post">
						    <input type="hidden" name="id" value="${dept.id}">
							  <button class="no-btn" type="submit">${Const.IMG_TRASH}</button>
						  </form>
						</td>
						<!-- ============================================== -->
					</tr>
				</c:forEach>
			</table>
		</article>
		<%@ include file="../common/aside.jsp" %>	
	</main>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>