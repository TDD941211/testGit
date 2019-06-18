package com.project.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.bean.UserBean;
import com.project.service.IUserService;

/**
 * 自定义的Realm 
 * @author Mac Book Pro
 *
 */
public class MyRealm extends AuthorizingRealm{
	@Autowired
	private IUserService service;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String name = token.getPrincipal().toString();
		UserBean user = service.findByName(name);
		System.out.println(user);
		AuthenticationInfo info  = null;
		if(user!=null){
			ByteSource by = ByteSource.Util.bytes(name);
			info = new SimpleAuthenticationInfo(user.getName(), user.getPassword(),by,getName());
		}
		return info;
	}
	
}
