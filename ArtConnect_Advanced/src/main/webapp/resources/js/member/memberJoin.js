  /** 
  *회원가입 처리
  */
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

        // 비밀번호 확인
        if (pw !== pwConfirm) {
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        }

      	if($('#id').val() == ""){
			alert("아이디를 입력해주세요.");
			return false;
		}

        // 모든 조건을 통과하면 회원가입 실행
        return true;
    }

  
    
   