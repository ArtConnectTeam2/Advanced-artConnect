package com.multi.artConnect.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {
	
	private final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;

	// 커스텀 로그인 페이지로 넘어가기
	@GetMapping("/customLogin")
	public String showLoginForm() {
		return "/member/customLogin";
	}
	

	// 회원가입페이지로 넘어가기
	@GetMapping("/register")
	public String showRegisterForm() {
		return "member/Register";
	}

	//회원가입 시 사용하는 메서드
	@RequestMapping("/insert.member")
	public String insert(MemberVO memberVO, AuthVO authVO, Model model, HttpServletRequest request) {
		try {
			/* 이 부분에서 깃 충돌 발생 */
			System.out.println("회원가입 성공: " + memberVO.toString());
			System.out.println("권한 부여됨: " + authVO.toString());
			memberService.insert(memberVO, authVO);
			model.addAttribute("message", "Registration successful");
			return "/member/RegisterSuccess";
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("errorMessage", "중복된 아이디입니다. 다른 아이디를 사용해주세요");
			return "/member/Register";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "에러가 발생했습니다");
			e.printStackTrace();
			return "/member/Register";
		}
	}
	
	@RequestMapping("/admin/allMember")
	public String findAll(Model model) {
	    
		List<MemberVO> memberVOList = memberService.findAll();
	    
		model.addAttribute("memberList", memberVOList);
	    
		return "/admin/allMember";
	}

}
