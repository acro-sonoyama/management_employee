<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="content">
		<div class="title">社員管理システム</div>

		<c:if test="${user != null}">
			<div class="user_info">
				ようこそ、<a href="?actionId=EmpUpdateInput">${user.empName}</a>さん
				<span class="pipeline">|</span>
				<a href="?actionId=Top">ログアウト</a>
			</div>
		</c:if>
	</div>
</header>