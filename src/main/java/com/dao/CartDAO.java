package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;

@Repository
public class CartDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	// 장바구니 저장
	public int cartAdd( CartDTO dto) {
		int n = session.insert("CartMapper.cartAdd", dto);
		return n;
	}
	
	//장바구니 목록
	public List<CartDTO> cartList( String userid){
//		List<CartDTO> list = session.selectList("", userid);
		return session.selectList("CartMapper.cartList", userid);
	}
	
   // 수량 수정
	public int cartUpdate( HashMap<String, Integer> map) {
		return session.update("CartMapper.cartUpdate", map);
	}
	 // 단일 삭제 
	public int cartDelete( int num) {
		return session.delete("CartMapper.cartDelete", num);
	}	
	// 다중 삭제 
	public int cartDeleteAll( List<String> num) {
		return session.delete("CartMapper.cartDeleteAll", num);
	}	
}
