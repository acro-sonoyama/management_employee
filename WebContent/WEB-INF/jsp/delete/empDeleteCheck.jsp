<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<h3>社員削除確認画面</h3>
			<div class="update">
				<div class="form">
					<div class="label">パスワード：</div>
					<div class="input">※非表示</div>
				</div>
				<div class="form">
					<div class="label">社員名：</div>
					<div class="input">${emp.empName}</div>
				</div>
				<div class="form">
					<div class="label">性別：</div>
					<div class="input">${emp.gender == 1 ? '男性' : '女性'}</div>
				</div>
				<div class="form">
					<div class="label">住所：</div>
					<div class="input">${emp.address}</div>
				</div>
				<div class="form">
					<div class="label">生年月日：</div>
					<div class="input">${emp.birthday}</div>
				</div>
				<div class="form">
					<div class="label">権限：</div>
					<div class="input">${emp.authority == 1 ? '一般' : '管理者'}</div>
				</div>
				<div class="form">
					<div class="label">部署名：</div>
					<div class="input">${emp.department.deptName}</div>
				</div>

				<form action="?actionId=EmpDeleteComplete" method="post">
					<div class="form">
						<div class="label"></div>
						<div class="input">
							<input type="submit" value="削除" />
						</div>
					</div>
				</form>

				<form action="?actionId=EmpList" method="post">
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