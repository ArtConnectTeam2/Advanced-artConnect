package com.multi.artConnect.member;

import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberDAO {

	public static final String Mapper = "com.multi.artConnect.mapper.MemberMapper.";
	
	@Autowired
	SqlSessionTemplate my;

	// 회원가입 및 권한 삽입
	@Transactional
	public void insert(MemberVO memberVO, AuthVO authVO) {
		// 회원 정보 삽입
		my.insert(Mapper +"insert", memberVO);
		// 회원 권한 삽입
		my.insert(Mapper + "insertAuth", authVO);
	}

	public int idCheck(String memberID) {
		return my.selectOne(Mapper + "idCheck", memberID);
	}

	public MemberVO login(MemberVO memberVO) {
		return my.selectOne(Mapper + "login", memberVO);
	}

	// 아이디를 통하여 회원정보 가져오기
	public MemberVO getData(String memberID) {
		return my.selectOne(Mapper + "getData", memberID);
	}
	
	
	//회원관리 페이지에서 회원정보 전체 불러오기
	public List<MemberVO> findAll() {
	    return my.selectList(Mapper + "findAll");
	}
	
	//회원 권한 업데이트
	public void updateRole(Map<String, Object> params) {
		my.update(Mapper + "updateRole", params);
	}
}
