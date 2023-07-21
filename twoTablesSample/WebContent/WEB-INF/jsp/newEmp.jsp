<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<%@ include file="./common/head.jsp" %>
<body>
	<%@ include file="./common/header.jsp" %>
	<main class="main">
		<article>
			<h1>新規社員登録</h1>
			<c:if test="${not empty errmsgList}">
				<ul>
					<c:forEach var="errmsg" items="${errmsgList}">
						<li><c:out value="${errmsg}"/></li>
					</c:forEach>
				</ul>
			</c:if>
			<form method="post" 
			      action="${pageContext.request.contextPath}/new">
				<table>
					<tr>
						<th>ID</th>
						<td><input class="no-border" type="text" name="id" 
						           placeholder="EMP000"
						           value='<c:out value="${employee.id}"/>'></td>
					</tr>
					<tr>
						<th>名前</th>
						<td><input class="no-border" type="text" name="name"
						           value='<c:out value="${employee.name}"/>'></td>
					</tr>
					<tr>
						<th>年齢</th>
						<td><input class="no-border" type="text" name="age"
						           value='<c:out value="${(ageTxt != null) ? ageTxt : employee.age}"/>'></td>
					</tr>
					<tr>
						<th>部署</th>
						<td>
							<select name="dept_id">
								<c:forEach var="dept" items="${deptList}">
									<option value="${dept.id}">${dept.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
				<input type="submit" value="確認">
				<a href="${pageContext.request.contextPath}/list">
				  <button type="button">取消</button></a>
			</form>
		</article>
		<%@ include file="./common/aside.jsp" %>	
	</main>
	<%@ include file="./common/footer.jsp" %>
</body>
</html>