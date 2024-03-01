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

        // 필수 입력 필드 체크
        var requiredFields = ["memberID", "memberPW", "pwConfirm", "memberName", "memberBirth", "memberTel", "memberEmail"];
        for (var i = 0; i < requiredFields.length; i++) {
            var fieldId = requiredFields[i];
            var fieldValue = document.getElementById(fieldId).value.trim();

            if (fieldValue === "") {
                alert("필수 입력 항목을 모두 입력하세요.");
                return false;
            }
        }

        // 모든 조건을 통과하면 회원가입 실행
        return true;
    }

    function submitForm() {
        // 생년월일 필드 값 가져오기
        var birthValue = document.getElementById("birth").value;

        // 값이 비어있는 경우 null로 설정
        if (birthValue.trim() === "") {
            document.getElementById("birth").value = null;
        }

        // 나머지 폼 데이터를 서버에 전송 또는 폼 submit 로직 수행
        document.forms["joinForm"].submit();
    }
    
    function corp_chk() {
        $("#corp_reg").val($("#corp_reg").val().replace(/[^0-9]/g, ""));
        reg_num = $("#corp_reg").val();

        if(!reg_num) {
            alert("사업자등록번호를 입력해주세요.");
            return false;
        }

        var data = {
            "b_no": [reg_num]
        };
        
        $.ajax({
        	// serviceKey 값을 xxxxxx에 입력
        	url: "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=Vl7h1TuqFiZ2aMRQifCEntOxpY9VfgYl6rpl2s0O6AJlR3UAfWyuPdMrwr75/7wsirV4AWNGwqfYypnXPSM32A==",  
            type: "POST",
            data: JSON.stringify(data), // json 을 string으로 변환하여 전송
            dataType: "JSON",
            traditional: true,
            contentType: "application/json; charset:UTF-8",
            accept: "application/json",
            success: function(result) {
                console.log(result);
                if(result.match_cnt == "1") {
                    //성공
                    console.log("success");
                    document.getElementById( "checkCorpMsg" ).innerText = "OK";
                    $('#checkCorpMsg').css("color","green");
                } else {
                    //실패
                    console.log("fail");
                    document.getElementById( "checkCorpMsg" ).innerText = "NOT OK";
                    $('#checkCorpMsg').css("color","red");
                    alert(result.data[0]["tax_type"]);
                }
            },
            error: function(result) {
                console.log("error");
                console.log(result.responseText); //responseText의 에러메세지 확인
            }
        });
    }