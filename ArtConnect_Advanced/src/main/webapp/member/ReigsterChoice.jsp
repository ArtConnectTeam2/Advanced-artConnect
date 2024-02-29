<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 유형 선택</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
#logo-image {
	max-width: 500px;
	position: relative;
}

.card-img-top {
	height: 200px; /* 이미지 높이 설정 */
	object-fit: contain; /* 이미지 비율 유지하며 컨테이너에 맞춤 */
}
</style>
</head>
<body>
	<header
		class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
		<a href="${pageContext.request.contextPath}/gallery/main.jsp"
			class="d-inline-flex link-body-emphasis text-decoration-none"> <img
			id="logo-image"
			src="${pageContext.request.contextPath}/resources/img/gallery/메인 홈페이지/art.png"
			title="art connect" alt="Art Connect" />
		</a>
	</header>


	<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
		<a class="navbar-brand" href="#">회원가입</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">전시관
						조회 및 검색 <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">예약</a></li>
				<li class="nav-item"><a class="nav-link" href="#">커뮤니티</a></li>
				<li class="nav-item"><a class="nav-link" href="#">마이페이지</a></li>
				<li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
				<li class="nav-item"><a class="nav-link" href="#">QnA</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<h1 class="mt-5">회원가입 유형 선택</h1>
		<p>안녕하세요! 회원가입을 진행하기 전에 회원가입 유형을 선택해주세요.</p>
		<div class="row">
			<div class="col-sm-6">
				<div class="card">
					<img class="card-img-top"
						src="${pageContext.request.contextPath}/resources/img/member/member.png"
						alt="일반 사용자 이미지">
					<div class="card-body d-flex flex-column align-items-center">
						<!-- 클래스 추가 -->
						<h5 class="card-title">일반 사용자 회원가입</h5>
						<a href="${pageContext.request.contextPath}/member/register" class="btn btn-primary">가입하기</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card">
					<img class="card-img-top"
						src="${pageContext.request.contextPath}/resources/img/member/museum.png"
						alt="미술관 관계자 이미지">
					<div class="card-body d-flex flex-column align-items-center">
						<!-- 클래스 추가 -->
						<h5 class="card-title">미술관 관계자 회원가입</h5>
						<a href="${pageContext.request.contextPath}/member/register" class="btn btn-secondary">가입하기</a>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>