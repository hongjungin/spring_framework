package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.GoodsDTO;

public interface CartService {
	public int cartAdd(CartDTO dto); 
	public List<CartDTO> cartList(String userid);
	public int cartUpdate(HashMap<String, Integer> map);
	public int cartDelete(int num);
	public int cartDeleteAll(List<String> num);
}
