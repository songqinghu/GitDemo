package com.git.base.login;

import org.springframework.data.mongodb.LazyLoadingException;

import com.hp.hpl.sparta.xpath.ThisNodeTest;

/**
 * 
 * <p>Title: Login.java</p>
 * <p>Description: 登录类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年4月28日下午10:20:46
 * @version 1.0
 */
public class Login {

	private static String username = "admin";
	
	private static String password = "12345";
	
	
	public static boolean getInfo(String[] info){
		
		if(info.length!=2){
			System.err.println("请输入正确的参数: username password");
			System.exit(1);
		}
		
		return login(info[0], info[1]);
	}
	
	
	private static boolean login(String name,String password){
		
		if(Login.username.equals(name)&&Login.password.equals(password)){
			System.out.println("欢迎您:"+name+" 登录系统!");
			return true;
		}else{
			System.out.println("请输入正确的用户名和密码!");
			return false;
		}
		
	}
	
	
}
