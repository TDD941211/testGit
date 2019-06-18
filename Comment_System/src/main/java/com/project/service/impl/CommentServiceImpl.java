package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.CommentBean;
import com.project.dao.ICommentDao;
import com.project.service.ICommentService;
@Service
public class CommentServiceImpl implements ICommentService{
	@Autowired
	private ICommentDao dao;
	
	@Override
	public List<CommentBean> findAll(int id) {
		
		return dao.findAll(id);
	}

	@Override
	public boolean addComment(CommentBean comment) {
		int gid = comment.getGoods().getId();
		boolean re = dao.addCommentNum(gid);
		if(re==true){
			dao.addComment(comment);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean addCommentNum(int id) {
		boolean re = dao.addCommentNum(id);
		return re;
	}

}
