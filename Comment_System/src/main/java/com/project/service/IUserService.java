package com.project.service;

import java.util.List;

import com.project.bean.UserBean;

public interface IUserService {
	
	public List<UserBean> findAll();
	
	public boolean login(UserBean user);
	
	public boolean reg(UserBean user);
	
	public UserBean findByName(String name);
}
