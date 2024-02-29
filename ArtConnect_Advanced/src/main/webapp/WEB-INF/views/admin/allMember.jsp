<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<!-- 필요한 다른 정보들 -->
					</tr>
				</thead>
				<tbody>
					<%
						// 여기서 데이터베이스에서 사용자 정보를 가져와서 표시합니다.
					// 이 부분은 실제 데이터베이스와 연동해서 작성해야 합니다.
					// 아래는 단순 예시입니다.
					%>
					<c:forEach var="member" items="${memberList}">
						<tr>
							<th scope="row">${member.memberID}</th>
							<td>${member.memberName}</td>
							<td>${member.memberEmail}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>