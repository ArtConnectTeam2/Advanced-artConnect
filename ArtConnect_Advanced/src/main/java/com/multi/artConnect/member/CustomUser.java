package com.multi.artConnect.member;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUser extends User{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MemberVO member;
	
	public CustomUser(String memberID, String memberPW,
			Collection<? extends GrantedAuthority> authorities) {
		super(memberID, memberPW, authorities);
		
	}
	
	//CustomUser가 상속한 User클래스를 기준으로 생성자를 생성하면
	// VO와 시큐리티를 연동할 수 있습니다
	public CustomUser(MemberVO vo) {
		super(vo.getmemberID(), vo.getmemberPW(), 
				(Collection<? extends GrantedAuthority>) vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		this.setMember(vo);
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

}
