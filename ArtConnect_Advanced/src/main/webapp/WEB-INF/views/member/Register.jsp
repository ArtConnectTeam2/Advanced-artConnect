<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="kor">
<head>
<title>회원 가입 페이지</title>
<%@ include file="/header.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/member/memberJoin.js"></script>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

form {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 1200px;
	width: 100%;
	background-color: #fff;
}

label {
	margin-bottom: 8px;
}

input, select {
	width: 100%;
	padding: 8px;
	margin-bottom: 16px;
	box-sizing: border-box;
}

button {
	background-color: #007bff;
	color: #fff;
	padding: 10px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

.navy {
	position: absolute;
	top: 10px;
	right: 10px;
}

label {
	font-size: 20px;
}

input {
	font-size: 15px;
}
</style>
</head>
<body>
	<!-- 메인 로고, 네비, 로그인-로그아웃 버튼 -->
	<%@ include file="/nav.jsp"%>

	<!-- 회원가입 폼 -->
	<main role="main-home-wrapper" class="container mt-5">
		<h1>회원가입 페이지</h1>
		<div class="container mt-3">
			<hr>
			<form action="insert.member" method="post" name="joinForm"
				onsubmit="return joinMember();">
				<h2 align="center">회원가입</h2>

				<label for="memberID">아이디: (필수)</label> <input type="text" id="memberID"
					name="memberID" required placeholder="아이디를 입력하세요" value="member03">


				<!-- 이미 가입된 아이디를 입력했을 경우 에러 메세지 -->
				<c:if test="${not empty errorMessage}">
					<div class="error-message" style="color: red">${errorMessage}</div>
				</c:if>
				<!-- 비밀 번호 -->
				<label for="pw">비밀번호: (필수)</label> <input type="password" id="pw"
					name="memberPW" required
					placeholder="비밀번호를 입력하세요(8자 이상이며 대문자, 소문자, 특수문자를 포함해야합니다)"
					value="Asdf1234*"> <span id="pw_check1" style="color: red;"></span><br>

				<label for="pwConfirm">비밀번호 확인: (필수)</label> <input type="password"
					id="pwConfirm" name="pwConfirm" required
					placeholder="비밀번호를 다시 입력하세요" value="Asdf1234*"> 
				<label for="name">이름: (필수)</label> 
				<input type="text" id="name"
					name="memberName" required placeholder="이름을 입력하세요" value="이용자03">

				<label for="birth">생년월일:(필수)</label> <input type="date" id="birth"
					name="memberBirth" required placeholder="생년월일을 선택하세요"
					min="1950-01-01" max="2020-12-31"> 
				
				<label for="gender">성별:(선택)</label> 
				<select id="gender" name="memberGender">
					<option value=" ">입력하지않음</option>
					<option value="M">남성</option>
					<option value="F">여성</option>

				</select> 
				<label for="addr">주소: (선택)</label> 
				<input type="text" id="addr"
					name="memberAddr" placeholder="주소">
				<input type="text" id="extraAddr"
					name="memberAddr" placeholder="상세주소">
				<button type="button" onclick="selectAddr()">주소 선택하기</button> <br>
				<hr>
				
				<label for="tel">전화번호:(필수)</label> 
				<input type="tel" id="tel" name="memberTel" required
					placeholder="전화번호를 입력하세요" value="010"> 
				
				<label for="email">이메일: (필수)</label> 
				<input type="email" id="email" name="memberEmail" required
					placeholder="이메일을 입력하세요" value="yangju12388@gmail.com">
				<button type="button" id=emailAuthBtn class="emailAuthBtn">인증번호 받기</button> <br>
				<hr>
					<label >인증번호 입력</label>
					<input type="text" placeholder="인증번호 입력" id="emailAuthKey">
				<br>
					

				<hr>
				<label for="alarm">알람 설정: (선택)</label> <select id="alarm"
					name="memberAlarm">
					<option value=" ">입력하지않음</option>
					<option value="email">이메일</option>
					<option value="sms">SMS</option>
					<option value="push">앱 푸시</option>
				</select> 
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
				<input type="hidden" name="auth"
					value="ROLE_MEMBER" />
				<button type="submit" onclick="joinMember()">회원가입</button>
						

			</form>
		</div>
	</main>

	<!-- footer -->
	<%@ include file="/footer.jsp"%>


	<!-- JavaScript -->
	<%@ include file="/alljs.jsp"%>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	

	
</body>
</html>
