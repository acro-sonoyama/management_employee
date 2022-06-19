<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/layout.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<title>社員管理システム</title>
</head>
<body>
	<%@include file="/WEB-INF/jsp/common/header.jsp"%>

	<div class="content">
		<c:forEach var="message" items="${requestScope.errorMessages}">
			<c:out value="${message}" />
			<br />
		</c:forEach>
	</div>
	<div class="content">
		<h3>エラーが発生しました。管理者へお問い合わせください</h3>

	</div>


	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>