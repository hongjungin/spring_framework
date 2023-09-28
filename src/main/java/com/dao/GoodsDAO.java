package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.GoodsDTO;

@Repository
public class GoodsDAO {

	@Autowired
	SqlSessionTemplate session;
	
	//상품목록
	public List<GoodsDTO> goodsList(String gCategory){
		List<GoodsDTO> list = 
				session.selectList("GoodsMapper.goodsList", gCategory);
		return list;
	}
	
	// 상품 자세히 보기
	public GoodsDTO goodsRetrieve( String gCode) {
		GoodsDTO dto = session.selectOne("GoodsMapper.goodsRetrieve", gCode);
		return dto;
	}
}
