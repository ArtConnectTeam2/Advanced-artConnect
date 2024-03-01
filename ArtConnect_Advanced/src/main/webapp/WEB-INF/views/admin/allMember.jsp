<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>전체 회원 목록</title>

</head>
<body>
	<%@ include file="/sidebar.jsp"%>
	<!-- 본문 -->
	<div id="page-content-wrapper">
		<div class="container-fluid">
			<h1 class="mt-4">전체 회원 목록</h1>

			<table class="table">
				<thead class="thead-light">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">이름</th>
						<th scope="col">이메일</th>
						<th scope="col">가입 날짜</th>
						<th scope="col">마지막 업데이트 날짜</th>
						<th scope="col">부여된 권한</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="member" items="${memberList}">
						<tr>
							<th scope="row">${member.memberID}</th>
							<td>${member.memberName}</td>
							<td>${member.memberEmail}</td>
							<td><fmt:formatDate value="${member.regDate}" pattern="yyyy년 MM월 dd일" /></td>
							<td><fmt:formatDate value="${member.updateDate}" pattern="yyyy년 MM월 dd일" /></td>
							<td><c:forEach var="auth" items="${member.authList}"> ${auth.auth}</c:forEach>
							</td>

						</tr>
					</c:forEach>
					<form action="/customLogout" method="post">
						<input type="submit" value="Logout"> <input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>