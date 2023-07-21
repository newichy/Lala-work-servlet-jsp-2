<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<%@ include file="../common/head.jsp" %>
<body>
	<%@ include file="../common/header.jsp" %>
	<main class="main">
		<article>
			<h1>新規部署登録</h1>
			<c:if test="${not empty errmsgList}">
				<ul>
					<c:forEach var="errmsg" items="${errmsgList}">
						<li><c:out value="${errmsg}"/></li>
					</c:forEach>
				</ul>
			</c:if>
			<form method="post" 
			      action="${pageContext.request.contextPath}/newDept">
				<table>
					<tr>
						<th>ID</th>
						<td><input class="no-border" type="text" name="id" 
						           placeholder="D00"
						           value='<c:out value="${dept.id}"/>'></td>
					</tr>
					<tr>
						<th>部署名</th>
						<td><input class="no-border" type="text" name="name"
						           value='<c:out value="${dept.name}"/>'></td>
					</tr>
				</table>
				<input type="submit" value="確認">
				<a href="${pageContext.request.contextPath}/deptList">
				  <button type="button">取消</button></a>
			</form>
		</article>
		<%@ include file="../common/aside.jsp" %>	
	</main>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>