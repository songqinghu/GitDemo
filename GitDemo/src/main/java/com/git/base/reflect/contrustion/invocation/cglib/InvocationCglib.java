package com.git.base.reflect.contrustion.invocation.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;



/**
 * cglib 代理类
 * <p>Title: InvocationCglib.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年6月4日下午3:30:41
 * @version 1.0
 */
public class InvocationCglib  implements MethodInterceptor{

	private Object obj;
	
	//生成子类 绑定代理类
	public Object bind(Object obj){
		
		this.obj = obj;
		
		Enhancer enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(obj.getClass());
		//设置回调
		enhancer.setCallback(this);
		
		//创建代理对象
		return enhancer.create();
		
	}

	@Override
	public Object intercept(Object arg, Method arg1, Object[] args, MethodProxy proxy) throws Throwable {
		
		System.out.println("proxy start ");
		
		Object result = proxy.invokeSuper(arg, args);//注意这里的参数不同
		
		System.out.println("proxy start ");
		
		return result;
	}

	
	


	
	
}
