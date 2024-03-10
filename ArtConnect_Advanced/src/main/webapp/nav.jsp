<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<div class="custom-header">
	<!-- 로고 -->
	<div class="logo">
		<a href="${pageContext.request.contextPath}/gallery/main.jsp"
			class="logo-link"> <img id="logo-image"
			src="${pageContext.request.contextPath}/resources/img/gallery/메인 홈페이지/art.png"
			title="art connect" alt="avana LLC" />
		</a>
	</div>


	<sec:authorize access="isAnonymous()">
		<div class="login" style="display: inline-block;">
			<a href="${pageContext.request.contextPath}/member/customLogin">
				<button class="btn btn-danger">로그인</button>
			</a>
		</div>
	</sec:authorize>


	<sec:authorize access="isAuthenticated()">
		<!-- 로그아웃 버튼 -->
		<div class="login" style="display: inline-block;">
			<a href="${pageContext.request.contextPath}/member/Logout.jsp">
				<button class="btn btn-info">로그아웃</button>
			</a> <br> <a
				href="${pageContext.request.contextPath}/mypage/updateOne?memberID=${memberID}"
				style="display: inline-block;"> <img id="my-image"
				src="${pageContext.request.contextPath}/resources/img/member/mymy.png">
			</a> <br> <span class="customer"> <sec:authentication
					property="principal.member.memberName" />님
			</span>
		</div>
	</sec:authorize>
</div>

<!-- header -->
<header role="header">

	<nav role="header-nav" class="navy">

		<ul>
			<li class="nav-active"><a
				href="${pageContext.request.contextPath}/gallery/list" title="Work">전시관
					조회 및 검색</a></li>

			<li><a
				href="${pageContext.request.contextPath}/reservation/gallerySelection.jsp"
				title="About">예약</a></li>

			<li><a
				href="${pageContext.request.contextPath}/review/boardList"
				title="Blog">커뮤니티</a></li>

			<li><a
				href="${pageContext.request.contextPath}/mypage/updateOne?memberID=${memberID}"
				title="Contact">마이 페이지</a></li>

			<li><a
				href="${pageContext.request.contextPath}/notice/noticeList"
				title="Contact">공지사항</a></li>

			<li><a href="${pageContext.request.contextPath}/notice/qnaList"
				title="Contact">QnA</a></li>

			<sec:authorize access="hasRole('ROLE_PARTNER')">
				<li><a
					href="${pageContext.request.contextPath}/gallery/programForm"
					title="Contact">프로그램 등록하기</a></li>
			</sec:authorize>
			
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a
					href="${pageContext.request.contextPath}/admin/home.jsp"
					title="Contact">관리자 페이지</a></li>
			</sec:authorize>
		</ul>
		<br>

	</nav>

	<!-- nav -->

</header>


<!-- header -->

