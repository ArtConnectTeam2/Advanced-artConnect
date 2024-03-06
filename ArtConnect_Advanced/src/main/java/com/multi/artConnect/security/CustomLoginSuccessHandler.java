package com.multi.artConnect.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	private final Logger log = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// 로그인 성공시 어떤 권한인지 체크하기 위해 부여받은 권한들을 로드
		// ROLE_ADMIN의 경우 ROLE_MEMBER와 함께 부여

		log.warn("로그인 성공");
		List<String> roleNames = new ArrayList<>();

		auth.getAuthorities().forEach(authority -> {

			roleNames.add(authority.getAuthority());
		});

		log.warn("부여받은 권한들 " + roleNames);

		if (roleNames.contains("ROLE_ADMIN")) {

			response.sendRedirect("/admin/home.jsp");
			return;
		}

		if (roleNames.contains("ROLE_MEMBER")) {

			response.sendRedirect("/member/LoginSuccess.jsp");
			return;
		}

		if (auth != null && auth.isAuthenticated()) {
			if (response.isCommitted()) {
				return;
			} // 로그인한 사용자가 로그인 페이지에 접근하려 할 때 메인 페이지로 리다이렉션합니다.
			response.sendRedirect("/gallery/main.jsp");
		}

	}

}
