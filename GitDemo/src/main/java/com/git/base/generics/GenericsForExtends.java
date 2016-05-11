package com.git.base.generics;

public class GenericsForExtends < T extends Info>{

	private T t ;
	public GenericsForExtends(T t){
		this.t = t;
	}
	
	public void getInfo(){
		System.out.println(t.toString());
	}
	
	
}
