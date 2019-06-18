package com.project.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.shiro.MyRealm;

/**
 * shiro的配置类
 * @author Mac Book Pro
 *
 */
@Configuration
public class ShiroConfig {
	/**
	 * shiro的核心过滤器
	 * @return
	 */
	@Bean(name="shiroFilterFactoryBean")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager securityManager){
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//需要注入安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//认证失败需要跳转的地址
		shiroFilterFactoryBean.setLoginUrl("/html/login.html");
		//授权失败需要跳转的地址
		shiroFilterFactoryBean.setUnauthorizedUrl("/html/fail.html");
		
		//设置访问路径的权限
		Map<String,String> fmap = new LinkedHashMap<String,String>();
		fmap.put("/html/login.html", "anon");
		fmap.put("/html/reg.html", "anon");
		fmap.put("/login", "anon");
		fmap.put("/reg", "anon");
		fmap.put("/html/main.html", "authc");
		fmap.put("/loginout", "logout");
		fmap.put("/**", "authc");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(fmap);
		
		
		return shiroFilterFactoryBean;
	}
	/**
	 * 定义安全管理器
	 * 
	 */
	@Bean(name="defaultWebSecurityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm1")MyRealm realm){
		
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(realm);
		return securityManager;
	}
	
	/**
	 * 使用md5来进行密码加密
	 * @return
	 */
	@Bean("hashedCredentialsMatcher")
	public HashedCredentialsMatcher getHashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		hashedCredentialsMatcher.setHashIterations(1024);
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
		return hashedCredentialsMatcher;
	}
	
	/**
	 * realm对象
	 * @return
	 */
	@Bean(name="myRealm1")
	public MyRealm getMyRealm(@Qualifier("hashedCredentialsMatcher")HashedCredentialsMatcher hashedCredentialsMatcher){
		MyRealm realm = new MyRealm();
		realm.setCredentialsMatcher(hashedCredentialsMatcher);
		return realm;
	}
	
	
	
	
}
