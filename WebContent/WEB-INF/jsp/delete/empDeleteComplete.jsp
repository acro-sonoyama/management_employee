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
				<h3>社員削除完了画面</h3>
				<div class="message">
					<p>社員削除処理が完了しました。</p>
					<p>
						<a href="?actionId=EmpList">一覧表示に戻る</a>
					</p>
				</div>
			</article>
		</div>

		<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
	</body>
</html>