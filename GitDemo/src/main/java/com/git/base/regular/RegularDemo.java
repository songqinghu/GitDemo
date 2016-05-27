package com.git.base.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 正则演示类
 * <p>Title: RegularDemo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月24日下午9:40:40
 * @version 1.0
 */
public class RegularDemo {

	
	public static void main(String[] args) {
		
		String mail = "jhewjhf2304@djf.cncn";
		System.out.println(mail + "是电子邮箱吗? \t" + splitMail(mail));
		
	}
	
	
	//判断传入的字符是否是邮箱 如果是 返回true 不是 返回false
	private static boolean splitMail(String mail){
		
		//定义一个规则类
		String regex ="\\@+";
		Pattern pattern = Pattern.compile(regex);
		
		String[] split = pattern.split(mail);
		for (String string : split) {
			System.out.println(string);
		}
		
		
		Matcher matcher = pattern.matcher(mail);
		//能否找到
		boolean find = matcher.find();
		System.out.println(find);
		//整个字符串是否匹配
		boolean matches = matcher.matches();
		System.out.println(matches);
		
		String replaceFirst = matcher.replaceFirst("****");
		System.out.println(replaceFirst);
		String replaceAll = matcher.replaceAll("***");
		System.out.println(replaceAll);
		
		return matches;
	}
	
}
