package com.git.base.reflect.contrustion.invocation.cglib;

public class CglibInvocationDemo {

	public static void main(String[] args) {
		
		Show show = new Show();
		
		InvocationCglib mid = new InvocationCglib();
		
		Show bind = (Show) mid.bind(show);
		
		
		bind.showOne("cglib");
		
		
		
	}
}
