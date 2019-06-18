package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.UserBean;
import com.project.dao.IUserDao;
import com.project.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;

	@Override
	public List<UserBean> findAll() {
		
		return dao.findAll();
	}

	@Override
	public boolean login(UserBean user) {
		UserBean bean = dao.findByNameAndPwd(user);
		if(bean!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean reg(UserBean user) {
		int i = dao.addUser(user);
		if(i==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public UserBean findByName(String name) {
		
		return dao.findByName(name);
	}
	
	

}
