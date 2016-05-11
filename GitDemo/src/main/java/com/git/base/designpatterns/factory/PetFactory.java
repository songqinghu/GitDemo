package com.git.base.designpatterns.factory;
/**
 * 
 * <p>Title: PetFactory.java</p>
 * <p>Description:工厂类设计模式 生产各种宠物实例</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月3日下午10:19:44
 * @version 1.0
 */
public class PetFactory {

	
	public  static Pet getIntance(String className){
		
		Pet pet = null;
		if("dog".equals(className)){
			pet = new Dog();
		}else if("cat".equals(className)){
			pet = new Cat();
		}else{
			pet = new DefaultPet();
		}
		return pet;
	}
	
}
