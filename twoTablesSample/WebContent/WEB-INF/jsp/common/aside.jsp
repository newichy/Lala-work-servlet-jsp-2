<%@ page language="java" 
    pageEncoding="UTF-8"%>
<aside>
	<h1>補助機能</h1>
	<div>
		<form class="find-box" method="post"
		      action="${pageContext.request.contextPath}/findName">
			<input class="no-border" type="text" name="name" 
			       placeholder="名前検索">
			<button class="no-btn">${Const.IMG_FIND}</button>
		</form>
	</div>
	<div>
		<form class="find-box" method="post"
		      action="${pageContext.request.contextPath}/findDept">
		  <select name="dept_id">
		  	<c:forEach var="dept" items="${deptList}">
		  		<option value="${dept.id}">${dept.name}</option>
		  	</c:forEach>
		  </select>
			<button class="no-btn">${Const.IMG_FIND}</button>
		</form>
	</div>
	<div><a href="${pageContext.request.contextPath}/list">社員一覧</a></div>
	<div><a href="${pageContext.request.contextPath}/new">新規社員登録</a></div>
	<div><a href="${pageContext.request.contextPath}/deptList">部署一覧</a></div>
	<div><a href="${pageContext.request.contextPath}/newDept">新規部署作成</a></div>
</aside>
