package com.git.base.comparable;

import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

public class Student implements Comparable<Student>{

	public Student(String name,int age,int score) {
		this.name = name;
		this.age = age;
		this.score= score;
	}
	
	private String name;
	
	private int age;

	private int score;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Student o) {
		
		//比较的逻辑定义
		if(this.getScore()>o.getScore()){
			return -1; //成绩大的在前面
		}else if (this.getScore()<o.getScore()) {
			return 1;
		}
		//都不是 分数相等 比较年龄
		if(this.getAge()<o.getAge()){
			return -1;
		}else if (this.getAge()>o.getAge()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		
		return name +" " + age + " " + score;
	}

	@Override
	public boolean equals(Object obj) {
		if(this ==obj){
			return true;
		}
		if(obj instanceof Student){
			Student s = (Student)obj;
			if(this.getName().equals(s.getName())&&this.getAge()==s.getAge()&&this.getScore()==s.getScore()){
				return true;
			}
		}
		
		return false;
		
		
	}
	
	
	
	
}
