package com.multi.artConnect.security;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
public class MemberTests {

	@Autowired
	private PasswordEncoder pwencoder;

	@Autowired
	private DataSource ds;

	@Test
	public void passwordEncoderIsNotNull() {
		assertNotNull(pwencoder);
	}

	@Test
	public void testInsertMember() {
		// 디비버에 회원 정보 추가
		String sql = "insert into member(memberID, memberPW, memberName) values(?, ?, ?)";

		// 100명의 회원정보를 기록
		for (int i = 0; i < 100; i++) {

			try {
				Connection con = null;
				PreparedStatement pstmt = null;

				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);

				pstmt.setString(2, pwencoder.encode("pw" + i));

				// 0~80 번까지는 일반 사용자
				if (i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "일반사용자" + i);
				} else if (i < 90) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(3, "운영자" + i);
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(3, "관리자" + i);
				}

				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testInsertAuth() {

		// 디비버에 Auth 테이블 추가
		String sql = "insert into member_auth (memberID, auth) values(?, ?)";

		for (int i = 0; i < 100; i++) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);

				// 0~80 번까지는 일반 사용자
				if (i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "ROLE_USER");
				} else if (i < 90) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(2, "ROLE_MEMBER");
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_ADMIN");
				}

				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
