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
			
			 if($('#emailAuthKey').val() == ""){
				alert("인증번호를 입력해주세요.");
				return false;
			}
	      	 
	        if($('#emailAuthKey').val() != emailAuthCd){
				alert("인증번호가 일치하지 않습니다.");
				return false;
			}

	        // 모든 조건을 통과하면 회원가입 실행
	        return true;
	    }
	    
	  function selectAddr() {
	     new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var roadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 참고 항목 변수

	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                //document.getElementById('sample4_postcode').value = data.zonecode; //우편번호
	                document.getElementById("addr").value = roadAddr;
	                //document.getElementById("sample4_jibunAddress").value = data.jibunAddress; //지번주소
	                
	                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
	                /* if(roadAddr !== ''){
	                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
	                } else {
	                    document.getElementById("sample4_extraAddress").value = '';
	                } */

	                
	            }
	        }).open();
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