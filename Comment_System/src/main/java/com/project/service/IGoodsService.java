package com.project.service;

import java.util.List;

import com.project.bean.GoodsBean;

public interface IGoodsService {
	
	public List<GoodsBean> findAll();
	
	public GoodsBean findById(int id);
}
