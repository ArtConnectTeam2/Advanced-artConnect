package com.multi.artConnect.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;


public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	private final Logger log = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

        
        log.error("Access Denied Handler");       
        log.error("Redirect.....");
        
        // AccessDeniedException의 메시지도 함께 로그에 남길 수 있습니다.
        log.error("Error Message: " + accessDeniedException.getMessage());
        
        response.sendRedirect("/gallery/main.jsp");
		
	}
	
}
