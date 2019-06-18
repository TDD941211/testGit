package com.project.controller;

import java.util.List;

import javax.validation.ReportAsSingleViolation;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.UserBean;
import com.project.service.IUserService;

@Controller
public class UserHandler {
	@Autowired
	private IUserService service;
	
	@RequestMapping("/login")
	public String login(ModelMap map,String name,String password){
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(name,password);
            try {
            	//调用login进行认证
                currentUser.login(token);
                System.out.println("认证成功");
                map.put("key", name);
                return "/main.html";
            } 
            // 父异常。认证失败异常
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("异常不详：自己解决");
            	return "redirect:/html/login.html";
            }
      }
		map.put("key", name);
		return "/main.html";
	}
	
	@RequestMapping("/reg")
	public String reg(String name,String password){
		
		Object obj = new SimpleHash("MD5", password, name, 1024);
		UserBean user = new UserBean();
		user.setName(name);
		user.setPassword(obj.toString());
		service.reg(user);
		
		return "redirect:/html/login.html";
	}
	
	
}
