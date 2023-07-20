<%@ page language="java" pageEncoding="UTF-8"%>
<aside>
	<div>
		<form class="aside-form"
			action="${pageContext.request.contextPath}/name" method="post">
			<input type="text" name="name" placeholder="名前検索">
			<button class="table-tool-txt">${Const.IMG_FIND}</button>
		</form>
	</div>
	
	<div>
		<a href="${pageContext.request.contextPath}/list" class="blue">社員一覧表示</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/deptList" class="blue">部署一覧表示</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/new" class="red">新規社員登録</a>
	</div>
		<div>
		<a href="${pageContext.request.contextPath}/newDept" class="red">新規部署登録</a>
	</div>
</aside>