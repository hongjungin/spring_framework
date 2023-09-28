<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- top.jsp -->
<!--  EL, jSTL로 변경하세요 -->
<!-- 
   login에 해당하는 키값을 
   request에서 먼저 찾고 없으면
    session에서 찾고 없으면
    application에서 최종적으로 찾는다. 
 -->
<c:if test="${empty login}">
	<a href="<c:url value='LoginUIServlet'/>">5로그인</a>
	<a href="<c:url value='MemberUIServlet'/>">회원가입</a>
</c:if>

<c:if test="${! empty login}">
안녕하세요${login.username}<br>
	<a href="<c:url value='LogoutServlet'/>">로그아웃</a>
	<a href="<c:url value='MyPageServlet'/>">mypage</a>
	<a href="<c:url value='CartListServlet'/>">장바구니목록</a>
</c:if>
