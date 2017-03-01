package com.git.books.b_design_patterns.e_singleton.one;
/**
 * 
 * @Description: 饿汉式单例模式
 * @author: songqinghu
 * @date: 2017年2月28日 下午2:09:01
 * Version:1.0
 */
public class MyCarOne {

    
    private static MyCarOne  car = new MyCarOne();
    
    
    private String engine;
    
    
    private MyCarOne(){
        engine="BMW";
    }
    
    
    public static MyCarOne getInstance(){
        return car;
    }
    
    
    @Override
    public String toString() {
        return "the car engine is : " + this.engine;
    }
    
}


class TestOne{
    public static void main(String[] args) {
        System.out.println(MyCarOne.getInstance() == MyCarOne.getInstance());
    }
}


