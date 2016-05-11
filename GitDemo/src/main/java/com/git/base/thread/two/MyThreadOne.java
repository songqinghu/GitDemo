package com.git.base.thread.two;

import com.google.common.base.StandardSystemProperty;

public class MyThreadOne  extends Thread{
	
	private String name;

	public MyThreadOne(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(name);
	}
	
	
	

}
