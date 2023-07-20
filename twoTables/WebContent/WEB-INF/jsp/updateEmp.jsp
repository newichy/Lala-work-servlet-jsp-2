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
			<h1>社員情報編集</h1>
			<c:if test="${not empty errmsgList}" >
				<ul>
					<c:forEach var="errmsg" items="${errmsgList}">
						<li><c:out value="${errmsg}" /></li>
					</c:forEach>
				</ul>
			</c:if>
			<form method="post" action="${pageContext.request.contextPath}/updateConfirm">
				<table>
					<tr>
						<th>ID</th>
						<th>名前</th>
						<th>年齢</th>
						<th>部署</th>
					</tr>
					<tr>
						<td><c:out value="${ emp.id }" /></td>
						<td><input type="text" name="name"  value='<c:out value="${ emp.name }" />'></td>
						<td><input type="text" name="age"  value='<c:out value="${ (_age != null ) ? _age : emp.age  }" />'></td>
						<td>
							<select name="dept_id">
								<c:forEach var="dept" items="${deptList}">
									<option value="${dept.id}" 
													${dept.id == emp.dept.id ? 'selected' : '' }>${dept.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
				<div id="table-footer">
					<input type="hidden" name="id" value="${ emp.id }" />
					<input class="table-footer-btn table-footer-btn-txt" type="submit" value="変 更">
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