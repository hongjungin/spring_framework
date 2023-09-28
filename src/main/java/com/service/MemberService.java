package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public interface MemberService {

	public MemberDTO idCheck(String userid);
	public int memberAdd(MemberDTO dto);
	public MemberDTO login(HashMap<String, String> map);
	
	public MemberDTO mypage(String userid);
}
