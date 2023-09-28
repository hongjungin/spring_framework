package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {

   //  view만 보여줄 때 , servlet-context.xml 에서 구현 가능
//<mvc:view-controller path="/LoginUIServlet" view-name="loginForm"/>
//	@GetMapping("/LoginUIServlet")
//	public String loginUI() {
//		return "loginForm";
//	}
	
	@Autowired
	MemberService service;
	
	@GetMapping("/LoginServlet")
	public String login(@RequestParam HashMap<String, String> map, 
			                          HttpSession session) {
		
		MemberDTO dto = service.login(map);
		String nextPage=null;
		if(dto != null) {
			session.setAttribute("login", dto);
			nextPage = "redirect:main";   
		}else {
			nextPage = "member/loginFail";  // /WEB-INF/views/member/loginFail.jsp
		}
		return nextPage;
	}
	
	@GetMapping("/LogoutServlet")
	public String logout( HttpSession session) {
		 session.invalidate(); //로그아웃
		return "redirect:main";
	}
	
	
	
	
	
	
	
	
}
