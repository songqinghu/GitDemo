package com.git.base.reflect.contrustion.invocation.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk的动态代理使用接口的形式来生成代理类
 * <p>Title: InvocationDemo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年6月4日下午2:34:47
 * @version 1.0
 */
public class InvocationDemo {

	
	public static void main(String[] args) throws ClassNotFoundException {
		
		//	one();
		two();
	}
	//匿名实现动态代理
	private static void one() throws ClassNotFoundException{
		
		final PersonSeelp person = new PersonSeelp();
		
		Seelp personInvocation = (Seelp) Proxy.newProxyInstance(person.getClass().getClassLoader(), PersonSeelp.class.getInterfaces()	,new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				method.invoke(person, args);
				return null;
			}
		});
		personInvocation.seelp("mysely");
	}
	//代理封装类
	private static void two(){
		
		PersonSeelp person = new PersonSeelp();
		
		MyInvocationInstance invocation = new MyInvocationInstance();
		
		Seelp proxy = (Seelp) invocation.binder(person);
		
		proxy.seelp("lalla");
	}
	
}
