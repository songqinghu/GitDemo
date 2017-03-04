package com.git.books.b_design_patterns.i_decorator;
/**
 * 
 * @Description: 人 
 * @author: songqinghu
 * @date: 2017年3月4日 下午3:25:53
 * Version:1.0
 */
public class People {

    private String name;

    private int age;
    
    private Gender gender;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return " my name : " + name + ", age :" + age + ", gender : " + gender+ " ";
    }
    
    
}
