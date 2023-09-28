package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@Controller
public class MainController {

	@Autowired
	GoodsService service;
	
	@GetMapping("/main")
	public String main(@RequestParam(value = "gCategory",
									 required = false,
									 defaultValue = "top"
			                         )   String gCategory,
									 Model m) {
		
		List<GoodsDTO> list = service.goodsList(gCategory);  // List<GoodsDTO> list 가 모델이다.
		m.addAttribute("goodsList", list);  // request.setAttribute("goodsList", list); 동일
		
		return "main";  // /WEB-INF/views/main.jsp
	}
}
