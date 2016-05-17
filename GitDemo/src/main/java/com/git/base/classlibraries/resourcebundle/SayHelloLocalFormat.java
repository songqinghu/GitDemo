package com.git.base.classlibraries.resourcebundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 根据语言库 获取不同的语言来获取相应的信息--进行格式化
 * <p>Title: SayHelloLocal.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月17日下午10:04:44
 * @version 1.0
 */
public class SayHelloLocalFormat {

	
	public static void main(String[] args) {
		
		Locale china = new Locale("zk", "CN");
		Locale us = new Locale("en", "US");
		Locale fr = new Locale("fr", "FR");
		
		ResourceBundle one = ResourceBundle.getBundle("hello", china);
		ResourceBundle two = ResourceBundle.getBundle("hello", us);
		ResourceBundle three = ResourceBundle.getBundle("hello", fr);
		
		System.out.println("one \t"+MessageFormat.format(one.getString("info"), "宋庆虎"));
		System.out.println("two \t"+MessageFormat.format(two.getString("info"), "宋庆虎"));
		System.out.println("three \t"+MessageFormat.format(three.getString("info"), "宋庆虎"));
	}
	
	
}
