package com.git.base.designpatterns.factory;

/**
 * 
 * <p>Title: Dog.java</p>
 * <p>Description:宠物狗类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月3日下午10:22:48
 * @version 1.0
 */
public class Dog implements Pet {

	
	@Override
	public String sayName() {
		
		return "my name is longlong ,what's your name?";
	}

}
