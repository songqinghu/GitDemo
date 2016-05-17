package com.git.base.classlibraries.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 根据语言库 获取不同的语言来获取相应的信息
 * <p>Title: SayHelloLocal.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月17日下午10:04:44
 * @version 1.0
 */
public class SayHelloLocal {

	
	public static void main(String[] args) {
		
		Locale china = new Locale("zk", "CN");
		Locale us = new Locale("en", "US");
		Locale fr = new Locale("fr", "FR");
		
		ResourceBundle one = ResourceBundle.getBundle("hello", china);
		ResourceBundle two = ResourceBundle.getBundle("hello", us);
		ResourceBundle three = ResourceBundle.getBundle("hello", fr);
		System.out.println("one \t"+one.getString("info"));
		System.out.println("two \t"+two.getString("info"));
		System.out.println("three \t"+three.getString("info"));
	}
	
	
}
