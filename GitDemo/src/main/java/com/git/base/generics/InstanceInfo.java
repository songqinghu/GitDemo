package com.git.base.generics;

public class InstanceInfo implements Info {

	private String age;
	
	private String name;
	
	private String gender;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "InstanceInfo [age=" + age + ", name=" + name + ", gender=" + gender + "]";
	}
	
	
	
	
}
