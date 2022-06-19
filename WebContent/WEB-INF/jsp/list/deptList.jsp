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

	<div class="container content">
		<%@include file="/WEB-INF/jsp/common/aside.jsp"%>

		<article class="main">
			<h3 class="page_title">部署一覧画面</h3>

			<c:if test="${user.authority == 2}">
				<a class="regist" href="?actionId=DeptRegistInput">新規部署登録</a>
			</c:if>

			<c:choose>
				<c:when test="${empty deptList}">
					<p class="notfound">該当する部署は存在しません。</p>
					<a class="notfound" href="?actionId=DeptList">部署一覧に戻る</a>
				</c:when>

				<c:otherwise>
					<table class="dept_list_table">
						<tr>
							<th class="deptId">部署ID</th>
							<th class="deptName">部署名</th>
							<c:if test="${user.authority == 2}">
								<th class="update">更新</th>
								<th class="delete">削除</th>
							</c:if>
						</tr>

						<c:forEach var="dept" items="${deptList}">
							<tr>
								<td>${dept.deptId}</td>
								<td>${dept.deptName}</td>
								<c:if test="${user.authority == 2}">
									<td class="button">
										<form action="?actionId=DeptUpdateInput" method="post">
											<button name="deptId" value="${dept.deptId}">変更</button>
										</form>
									</td>
									<td class="button">
										<form action="?actionId=DeptDeleteCheck" method="post">
											<button name="deptId" value="${dept.deptId}">削除</button>
										</form>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>

			<div class="message">
				<a href="?actionId=EmpList">社員一覧表示に戻る</a>
			</div>

		</article>
	</div>

	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>