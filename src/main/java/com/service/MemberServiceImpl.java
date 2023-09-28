package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO dao;
	
	@Override
	public MemberDTO idCheck(String userid) {
		MemberDTO dto = dao.idCheck(userid);
		return dto;
	}
	@Override
	public int memberAdd(MemberDTO dto) {
		 int n = dao.memberAdd(dto);
		return n;
	}
	@Override
	public MemberDTO login(HashMap<String, String> map) {
		MemberDTO dto = dao.login(map);
		return dto;
	}
	@Override
	public MemberDTO mypage(String userid) {
		MemberDTO dto = dao.mypage(userid);
		return dto;
	}

}
