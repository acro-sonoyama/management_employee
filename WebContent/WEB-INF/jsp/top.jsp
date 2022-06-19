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
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>

		<div class="content">
			<div class="login">
				<h3>ログイン画面</h3>

				<div class="form">
					<p>社員IDとパスワードを入力してください。</p>

					<c:if test="${!empty errorMessageList}">
						<c:forEach var="errorMessage" items="${errorMessageList}">
							<div style="color:red; text-align:center;">${errorMessage}</div>
						</c:forEach>
					</c:if>

					<form action="?actionId=Login" method="post">
						<div class="login_label">社員ID</div>
						<div class="login_input"><input type="text" name="empId" value="${empId}"  /></div>

						<div class="login_label">パスワード</div>
						<div class="login_input"><input type="password" name="empPass" value="${empPass}"  /></div>

						<div class="login_label"></div>
						<div class="login_input"><input type="submit" value="ログイン" /></div>
					</form>
				</div>
			</div>
		</div>

		<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
	</body>
</html>