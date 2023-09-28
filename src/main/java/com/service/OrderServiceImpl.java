package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CartDAO;
import com.dao.GoodsDAO;
import com.dao.OrderDAO;
import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO dao;
	
	@Override
	public CartDTO cartByNum(int num) {
		CartDTO cartDTO = dao.cartByNum(num);
		return cartDTO;
	}
	@Override
	public MemberDTO memberByUserid(String userid) {
		MemberDTO memberDTO = dao.memberByUserid(userid);
		return memberDTO;
	}
	@Override
	@Transactional // orderDone()와 cartDel() 모두 성공하면 자동으로 commit되고 , 하나라도 런타임예외가 발생시 모두 rollback됨.
	public int orderDone(OrderDTO dto, int del_num) {
		int n = dao.orderDone(dto);
			n = dao.cartDel(del_num);
		return n;
	}
}
