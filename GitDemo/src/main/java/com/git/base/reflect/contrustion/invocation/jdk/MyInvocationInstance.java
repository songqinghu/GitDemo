package com.git.base.reflect.contrustion.invocation.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationInstance implements InvocationHandler {

	private Object obj;
	
    public MyInvocationInstance() {
		 
	}
	
    public Object binder(Object obj){
    	this.obj = obj;
    	return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),this);
    }
    
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invocation start !");
		
		Object result = method.invoke(obj, args);
		
		System.out.println("invocation end !");
		return result;
	}

}
