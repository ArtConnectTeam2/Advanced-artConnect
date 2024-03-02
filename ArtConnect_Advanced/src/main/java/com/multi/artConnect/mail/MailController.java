package com.multi.artConnect.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail/*")
public class MailController {

	@Autowired
	private JavaMailSender mailSender;

	private static final Logger log = LoggerFactory.getLogger(MailController.class);

	@RequestMapping("/")
	public String home() {
		return "home.jsp"; 
	}

	@RequestMapping("admin/mailSend")
	public String showSend() {
		return "admin/mailSend";
	}

	@PostMapping("admin/doSend")
	public String mailSend(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String last_name = request.getParameter("last_name");
		String message = request.getParameter("Message");

		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();

			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			log.info("Message {}", mimeMessage);

			messageHelper.setFrom("artconnect222@gmail.com");

			messageHelper.setTo("yangju12388@gmail.com");

			messageHelper.setSubject("반갑습니다. 저는" + name + last_name + "입니다.");

			messageHelper.setText(message);
			model.addAttribute("message", "이메일 발송되었습니다");

			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
			model.addAttribute("message", "이메일 발송 실패했습니다");
		}

		return "/admin/mailSend";
	}
}
