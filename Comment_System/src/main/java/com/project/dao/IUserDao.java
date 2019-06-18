package com.project.dao;

import java.util.List;

import com.project.bean.UserBean;

public interface IUserDao {
	public List<UserBean> findAll();
	
	public UserBean findByNameAndPwd(UserBean user);
	
	public int addUser(UserBean user);
	
	public UserBean findByName(String name);
}
