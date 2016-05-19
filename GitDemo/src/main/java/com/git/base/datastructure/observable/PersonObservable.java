package com.git.base.datastructure.observable;

import java.util.Observable;

/**
 * 被观察者
 * <p>Title: PersonObservable.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月19日下午11:28:29
 * @version 1.0
 */
public class PersonObservable extends Observable {

	
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
	
	
	public boolean setUpdate(String name,int age){
		this.name = name;
		this.age  = age;
		setChanged();
		notifyObservers(age);
		return true;
	}
	
	

}
