package com.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;

@Repository
public class OrderDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public CartDTO cartByNum(int num) {
		return session.selectOne("OrderMapper.cartByNum", num);
	}
	public MemberDTO memberByUserid(String userid) {
		return session.selectOne("OrderMapper.memberByUserid", userid);
	}	
	public int orderDone(OrderDTO dto) {
		return session.insert("OrderMapper.orderDone", dto);
	}
	
    public int cartDel( int del_num) {
    	return session.delete("OrderMapper.cartDel", del_num);
    }
}
