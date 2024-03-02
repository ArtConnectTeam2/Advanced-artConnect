<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/sidebar.jsp"%>
<h1>Reservation Mail Send</h1>

	<div>
	<form action="/mail/admin/doSend" method="post">
		<div class="input_1">
			<label>성</label>
			<input type="text" name="name" placeholder="Name" required="">
		</div>	
		<div class="input_2">
			<label>이름</label>
			<input type="text" name="last_name" placeholder="last_Name" required="">
		</div>	
		<div class="input_3">
			<input type="email" name="email" placeholder="Email" required="">
		</div>	
		<div class="input_4">
			<textarea type="message" name="Message" placeholder="Message" required=""></textarea>
		</div>	
		<div>
			<div class="click">
				<input type="submit" value="SEND">			
			</div>
		</div>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
	</form>
	<span style="color:red;">${message}</span>
</div>
	
</body>
</html>