package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/MemberUIServlet")
	public String memberUI() {
		return "memberForm";
	}
	
	@PostMapping("/MemberAddServlet")
	public String memberAdd(MemberDTO dto) {
		int n = service.memberAdd(dto);
		
		return "redirect:LoginUIServlet";
	}
	
	@GetMapping("/MyPageServlet")
	public String mypage(HttpSession session) {
		 MemberDTO dto =
				  (MemberDTO)session.getAttribute("login");
		// 로그인 여부 확인은 Interceptor 이용한다.
		 String userid = dto.getUserid();
		 MemberDTO mypage = service.mypage(userid);
		 session.setAttribute("login", mypage);
		return "mypage";  // /WEB-INF/views/mypage.jsp
	}
	/*
	   1. ajax 연동
	   2. 응답을 jsp가 아닌 일반 데이터(문자열, JSON 형태)
	       ==> @ResponseBody
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.14.2</version>
</dependency>	
	*/
	@GetMapping(value="/MemberIdCheckServlet",
			  produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String idCheck(@RequestParam ("userid") 
	                           String userid) {
		MemberDTO dto = service.idCheck(userid);
		String mesg = "아이디 사용 가능";
		if(dto!=null) {
			mesg = "아이디 중복";
		}
		return mesg;
	}
	
	
	
}
