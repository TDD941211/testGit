package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.*;
import com.project.service.IGoodsService;
import com.project.service.IUserService;

@Controller
public class GoodsHandler {
	@Autowired
	private IGoodsService service;
	@Autowired
	private IUserService service2;

	@RequestMapping("/goods")
	@ResponseBody
	public List<GoodsBean> findAll(){
		List<GoodsBean> list = service.findAll();
		return list;
	}

	@RequestMapping("/goodsid")
	public String findById(ModelMap map,int id,String username){
		GoodsBean goods = service.findById(id);
		map.put("goods", goods);
		UserBean user = service2.findByName(username);
		int uid = user.getId();
		String password = user.getPassword();
		map.put("uid", uid);
		map.put("username", username);
		map.put("password", password);
		return "/goods.html";
	}
	
}
