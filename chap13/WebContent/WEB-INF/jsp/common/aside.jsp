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
		<a href="${pageContext.request.contextPath}/list" class="blue">全件表示</a>
	</div>
	
	<div>
		<a href="${pageContext.request.contextPath}/new" class="blue">新規登録</a>
	</div>
</aside>