<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="search">
	<div class="title">社員名検索</div>
	<div class="form">
		<form action="?actionId=EmpSearch" method="post">
			<input type="text" name="empName" />
			<input type="submit" value="検索" />
		</form>
	</div>

	<div class="title">部署名検索</div>
	<div class="form">
		<form action="?actionId=DeptSearch" method="post">
			<select name="deptId">
				<c:forEach var="dept" items="${deptList}">
					<option value="${dept.deptId}" >${dept.deptName}</option>
				</c:forEach>
			</select>
			<input type="submit" value="検索" />
		</form>
	</div>
</aside>