package com.git.base.designpatterns.factory;
/**
 * 
 * <p>Title: DefaultPet.java</p>
 * <p>Description:默认的宠物类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月3日下午10:28:10
 * @version 1.0
 */
public class DefaultPet implements Pet {

	@Override
	public String sayName() {
		return "You want me to call what name? ";
	}

}
