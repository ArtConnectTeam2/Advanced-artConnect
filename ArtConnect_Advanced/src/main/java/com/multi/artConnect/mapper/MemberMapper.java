package com.multi.artConnect.mapper;

import com.multi.artConnect.member.AuthVO;
import com.multi.artConnect.member.MemberVO;

public interface MemberMapper {

	public MemberVO read(String memberID);
	
	public void insert(MemberVO memberVO, AuthVO authVO);
}
