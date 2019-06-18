package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.GoodsBean;
import com.project.dao.IGoodsDao;
import com.project.service.IGoodsService;
@Service
public class GoodsServiceImpl implements IGoodsService{
	@Autowired
	private IGoodsDao dao;
	
	@Override
	public List<GoodsBean> findAll() {
		
		return dao.findAll();
	}

	@Override
	public GoodsBean findById(int id) {
		
		return dao.findById(id);
	}

}
