package com.multi.artConnect.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberDAO memberDAO;


    // 회원가입 메서드
    public void insert(MemberVO memberVO, AuthVO authVO) {
        // 입력된 비밀번호를 가지고온다.
    	String pwd = memberVO.getmemberPW();
    	
    	// 암호화 과정 (BCrypt 이용)
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	String encodedPwd = encoder.encode(pwd);
    	
    	// 암호화 된 코드를 memberVO에 다시 넣는다
    	memberVO.setmemberPW(encodedPwd);
    	
    	memberDAO.insert(memberVO, authVO);
        
    }
    
    
    // 회원가입시 아이디 중복 체크
    public int idCheck(String memberID) {
        // idCheck 메서드를 통해 중복 여부 확인
        int result = memberDAO.idCheck(memberID);
        return result;
    }
    
    
}
