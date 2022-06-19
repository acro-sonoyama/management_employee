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
			<h3 class="page_title">社員一覧画面</h3>

			<c:if test="${user.authority == 2}">
				<a class="regist" href="?actionId=EmpRegistInput">新規社員登録</a>
			</c:if>

			<c:choose>
				<c:when test="${empty empList}">
					<p class="notfound">該当する社員は存在しません。</p>
					<a class="notfound" href="?actionId=EmpList">社員一覧に戻る</a>
				</c:when>

				<c:otherwise>
					<table class="emp_list_table">
						<tr>
							<th class="empId">社員ID</th>
							<th class="empName">社員名</th>
							<c:if test="${user.authority == 2}">
								<th class="gender">性別</th>
								<th class="address">住所</th>
								<th class="birthday">生年月日</th>
								<th class="authority">権限</th>
							</c:if>
							<th class="deptName">部署名</th>
							<c:if test="${user.authority == 2}">
								<th class="update">更新</th>
								<th class="delete">削除</th>
							</c:if>
						</tr>

						<c:forEach var="emp" items="${empList}">
							<tr>
								<td>${emp.empId}</td>
								<td>${emp.empName}</td>
								<c:if test="${user.authority == 2}">
									<td>${emp.gender == 1 ? '男性' : '女性'}</td>
									<td>${emp.address}</td>
									<td>${emp.birthday}</td>
									<td>${emp.authority == 1 ? '一般' : '管理者'}</td>
								</c:if>
								<td>${emp.department.deptName}</td>
								<c:if test="${user.authority == 2}">
									<td class="button">
										<form action="?actionId=EmpUpdateInput" method="post">
											<button name="empId" value="${emp.empId}">変更</button>
										</form>
									</td>
									<td class="button">
										<form action="?actionId=EmpDeleteCheck" method="post">
											<button name="empId" value="${emp.empId}">削除</button>
										</form>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</table>

					<div class="message">
						<a href="?actionId=DeptList">部署一覧画面へ</a>
					</div>
				</c:otherwise>
			</c:choose>
		</article>
	</div>

	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>