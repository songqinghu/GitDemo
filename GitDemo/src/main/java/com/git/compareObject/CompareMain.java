package com.git.compareObject;

import java.util.jar.Pack200;

public class CompareMain {

	public static void main(String[] args) {
		comparePerson();
		
		
	}
	
	private static void comparePerson(){
		Person p1 = new Person();
		p1.setAge(1);
		p1.setName("1");
		
		Person p2 = new Person();
		p2.setAge(2);
		p2.setName("2");
		
		boolean falg1 = p1.compareTo(p1);
		boolean falg2 = p1.compareTo(p2);
		p2.setAge(1);
		p2.setName("1");
		boolean falg3 = p1.compareTo(p2);
		System.out.println(falg1);
		System.out.println(falg2);
		System.out.println(falg3);
		
	}
	
}
