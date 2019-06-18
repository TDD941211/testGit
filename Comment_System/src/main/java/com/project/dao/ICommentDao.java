package com.project.dao;
import java.util.List;

import com.project.bean.CommentBean;;

public interface ICommentDao {
	public List<CommentBean> findAll(int id);
	
	public int addComment(CommentBean comment);
	
	public boolean addCommentNum(int id);
}
