package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService service;
	
	@GetMapping("/OrderConfirmServlet")
	public String orderConfirm(@RequestParam("num") int num,
			                         HttpSession session, Model m) {
		CartDTO cDTO = service.cartByNum(num);
		
		 MemberDTO dto =
				  (MemberDTO)session.getAttribute("login");
		 String userid = dto.getUserid();
		 MemberDTO mDTO = service.memberByUserid(userid);
		 
		 //모델 저장
		 m.addAttribute("cDTO", cDTO);
		 m.addAttribute("mDTO", mDTO);
		return "orderConfirm";
	}
	
	
	@GetMapping("/OrderDoneServlet")
	public String orderDone(OrderDTO orderDTO, HttpSession session, 
			                 @RequestParam("num") int del_num, Model m) {
		 MemberDTO dto = (MemberDTO)session.getAttribute("login");
		 String userid = dto.getUserid();
		 orderDTO.setUserid(userid);
		 
		 int n = service.orderDone(orderDTO, del_num);
		 
		 m.addAttribute("orderDTO", orderDTO);  // 모델 저장
		return "orderDone";   // 뷰 지정
	}
	
}




