package com.git.base.designpatterns.factory;
/**
 * 
 * <p>Title: PetTest.java</p>
 * <p>Description:宠物测试类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月3日下午10:30:54
 * @version 1.0
 */
public class PetTest {

	
	public static void main(String[] args) {
		
		Pet pet1 = PetFactory.getIntance("");
		System.out.println(pet1.sayName());
		
		Pet pet2 = PetFactory.getIntance("dog");
		System.out.println(pet2.sayName());
		
		Pet pet3 = PetFactory.getIntance("cat");
		System.out.println(pet3.sayName());
	}
}
