package com.project.service;

import java.util.List;

import com.project.bean.CommentBean;

public interface ICommentService {
	public List<CommentBean> findAll(int id);
	
	public boolean addComment(CommentBean comment);
	
	public boolean addCommentNum(int id);
}
