package com.git.base.thread.two;

public class MyThreadTwo implements Runnable{

	private String name;
	
	public MyThreadTwo(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(name);
	}

}
