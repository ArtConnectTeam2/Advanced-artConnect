 /** 
	  *회원가입 처리
	  */
	  var emailAuthCd = '';
	 
	  function joinMember() {
	        

	        var pw = document.getElementById("pw").value;
	        var pwConfirm = document.getElementById("pwConfirm").value;
	        var pwErroMessage1 = document.getElementById("pw_check1");
	        
	        // 비밀번호가 비어있을 경우 조건 체크를 하지 않음
	        if (pw.trim() === "") {
	            pwErroMessage1.innerHTML = "";
	        } else {
	            var pwreg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;

	            if (!pwreg.test(pw)) {
	                pwErroMessage1.innerHTML = "비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.";
	                alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
	                return false;
	            } else {
	                pwErroMessage1.innerHTML = "";
	            }
	        }


	      	if($('#memberID').val() == ""){
				alert("아이디를 입력해주세요.");
				return false;
			}
	      	
	      	if($('#password').val() == ""){
				alert("비밀번호를 입력해주세요.");
				return false;
			}
	      	
	      	 // 비밀번호 확인
	        if (pw !== pwConfirm) {
	            alert("비밀번호가 일치하지 않습니다.");
	            return false;
	        }
	      	 
	        if($('#name').val() == ""){
				alert("이름을 입력해주세요.");
				return false;
			}
	        
	        if($('#birh').val() == ""){
				alert("생년월일을 선택해주세요.");
				return false;
			}
	      	 
	        if($('#emailAuthKey').val() != emailAuthCd){
				alert("인증번호가 일치하지 않습니다.");
				return false;
			}

	        // 모든 조건을 통과하면 회원가입 실행
	        return true;
	    }

	  $(function() {
		  console.log("문서가 준비되었습니다.");
		
		  $(".emailAuthBtn").click(function() {
			    console.log("인증번호 받기 버튼이 클릭되었습니다."); 
			    var email = $('#email').val();
			    alert("인증번호 받기 버튼 클릭함")
			    
			    if (email == '') {
			        alert("이메일을 입력하세요")
			        return false
			    }
			    
			   $.ajax({
			        type: "POST",
			        url : "/mail/emailAuth",
			        data: {memberEmail: email},
			        success: function(data) {
			            alert("인증번호가 발송되었습니다.");
			            emailAuthCd = data;
			        },
			         error: function(jqXHR, textStatus, errorThrown) {
        				alert("메일 발송에 실패했습니다.\nHTTP 상태 코드: " + jqXHR.status + "\n에러: " + errorThrown);
    				}
			    })
			})
	})