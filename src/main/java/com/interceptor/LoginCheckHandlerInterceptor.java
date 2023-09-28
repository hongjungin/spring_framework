package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dto.MemberDTO;

@Component("xxx")
public class LoginCheckHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 기능: request 이용해서 특별한 작업 수행 ==> 로그인 여부 확인
		System.out.println("LoginCheckHandlerInterceptor.preHandle");
		// 로그인 체크 여부 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		if(dto==null) {
			response.sendRedirect("/shop/LoginUIServlet"); // loginForm.jsp화면으로.., 절대경로
			return false; // Controller 요청안됨.
		}
		return true; // Controller로 요청됨.
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 기능: response 및 ModelAndView 이용해서 특별한 작업 수행 ==> ModelAndView 이용해서 view정보 변경 작업 가능
		System.out.println("LoginCheckHandlerInterceptor.postHandle");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginCheckHandlerInterceptor.afterCompletion");
	}

}
