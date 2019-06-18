package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.CommentBean;
import com.project.bean.GoodsBean;
import com.project.bean.UserBean;
import com.project.service.ICommentService;

@Controller
public class CommentHandler {
	@Autowired
	private ICommentService service;
	
	@RequestMapping("/comment")
	@ResponseBody
	public List<CommentBean> findComment(int gid){
		List<CommentBean> list = service.findAll(gid);		
		
		return list;
	}
	
	@RequestMapping("/addComment")
	@ResponseBody
	public List<CommentBean> addComment(String value,String time,int gid,int uid){
		CommentBean comment = new CommentBean();
		GoodsBean goods = new GoodsBean();
		UserBean user = new UserBean();
		user.setId(uid);
		comment.setContent(value);
		comment.setTime(time);
		goods.setId(gid);
		comment.setGoods(goods);
		comment.setUser(user);
		boolean re = service.addComment(comment);
		List<CommentBean> list = service.findAll(gid);
		return list;
	}
	
}
