package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;

public interface OrderService {
	public CartDTO cartByNum(int num);
	public MemberDTO memberByUserid(String userid);
	public int orderDone(OrderDTO dto, int del_num);
}
