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
			<h1>
				<c:if test="${not empty msg}">
					<c:out value="${ msg }" />
				</c:if>
			</h1>
			<div class="div-result-bottom"><a href="${pageContext.request.contextPath}/list">戻る</a></div>
		</article>
		<%@ include file="./common/aside.jsp"%>
	</main>
	<%@ include file="./common/footer.jsp"%>
</body>
</html>