package com.git.compareObject;

import java.util.Comparator;

/**
 * 
 * <p>Title: CompareAnyObject.java</p>
 * <p>Description:比较两个对象是否相同 </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年4月27日下午11:46:44
 * @version 1.0
 */
public class Person {

	
	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public boolean compareTo(Person per){
		
	    if(this == per){
	    	return true;
	    }
		
	    if(this.getAge()==per.getAge()&&this.getName().equals(per.getName())){
	    	return true;
	    }
	    
		return false;
	}
	
	
	
}
