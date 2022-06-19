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
			<h3>社員変更入力画面</h3>

			<c:if test="${!empty errorMessageList}">
				<c:forEach var="errorMessage" items="${errorMessageList}">
					<div style="color: red; text-align: center;">${errorMessage}</div>
				</c:forEach>
			</c:if>

			<div class="update">
				<form action="?actionId=EmpUpdateCheck" method="post">
					<div class="form">
						<div class="label">パスワード：</div>
						<div class="input">
							<input type="password" name="empPass" value="${emp.empPass}" />
						</div>
					</div>

					<div class="form">
						<div class="label">社員名：</div>
						<div class="input">
							<input type="text" name="empName" value="${emp.empName}" />
						</div>
					</div>

					<div class="form">
						<div class="label">性別：</div>
						<div class="input">
							<label><input type="radio" name="gender" value="1" <c:if test="${emp.gender != 2}">checked</c:if> />男性&nbsp;</label> <label><input type="radio" name="gender" value="2"
								<c:if test="${emp.gender == 2}">checked</c:if> />女性</label>
						</div>
					</div>

					<div class="form">
						<div class="label">住所：</div>
						<div class="input">
							<input type="text" name="address" value="${emp.address}" />
						</div>
					</div>

					<div class="form">
						<div class="label">生年月日：</div>
						<div class="input">
							<input type="text" name="birthday" value="${emp.birthday}" />(YYYY/MM/DD)
						</div>
					</div>

					<c:if test="${user.authority == 2}">
						<div class="form">
							<div class="label">権限：</div>
							<div class="input">
								<label><input type="radio" name="authority" value="1" <c:if test="${emp.authority != 2}">checked</c:if> />一般&nbsp;</label> <label><input type="radio" name="authority"
									value="2" <c:if test="${emp.authority == 2}">checked</c:if> />管理者</label>
							</div>
						</div>
					</c:if>

					<div class="form">
						<div class="label">部署名：</div>
						<div class="input">
							<select name="deptId">
								<c:forEach var="dept" items="${deptList}">
								<c:out value="${dept.deptId}" />
									<option value="${dept.deptId}" <c:if test="${dept.deptId == emp.department.deptId}">selected</c:if>>${dept.deptName}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form">
						<div class="label"></div>
						<div class="input">
							<input type="submit" value="変更" />
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