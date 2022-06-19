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
			<%@include file="/WEB-INF/jsp/common/aside.jsp"%>

			<article>
				<h3>部署登録確認画面</h3>

				<div class="update">
					<div class="form">
						<div class="label">部署名：</div>
						<div class="input">${dept.deptName}</div>
					</div>

					<form action="?actionId=DeptRegistComplete" method="post">
						<div class="form">
							<div class="label"></div>
							<div class="input">
								<input type="submit" value="登録" />
							</div>
						</div>
					</form>

					<form action="?actionId=DeptRegistInput" method="post">
						<div class="form">
							<div class="label"></div>
							<div class="input">
								<input type="submit" value="戻る" />
							</div>
						</div>
					</form>
				</div>
			</article>
		</div>

		<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
	</body>
</html>