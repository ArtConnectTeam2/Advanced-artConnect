<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>404 - 페이지를 찾을 수 없음</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	color: #333;
}

.container {
	margin: 50px auto;
	text-align: center;
}

h1 {
	font-size: 36px;
	color: #ff6347;
}

p {
	font-size: 18px;
}
</style>
</head>
<body>
	<div class="container">
		<img
			src="${pageContext.request.contextPath}/resources/img/error/404error.png"
			alt="404 Error Image">
		<h1>죄송합니다. 요청하신 페이지를 찾을 수 없습니다.</h1>
		<p>존재하지 않는 주소를 입력하셨거나, 요청하신 페이지의 주소가 변경, 삭제되어 찾을 수 없습니다.</p>
		<div>
			<a href="javascript:history.back()" class="button">이전 페이지</a> <a
				href="/" class="button">메인 페이지</a>
		</div>
	</div>
</body>
</html>
