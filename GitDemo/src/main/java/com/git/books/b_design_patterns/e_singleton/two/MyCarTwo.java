package com.git.books.b_design_patterns.e_singleton.two;

/**
 * 
 * @Description: 懒汉式单例模式
 * @author: songqinghu
 * @date: 2017年2月28日 下午2:09:01
 * Version:1.0
 */
public class MyCarTwo {

    
    private volatile static MyCarTwo  car;
    
    
    private String engine;
    
    
    private MyCarTwo(){
        engine="BMW";
    }
    
    
    public static MyCarTwo getInstance(){
        
        synchronized (MyCarTwo.class) {
            if(car ==null){
                car = new MyCarTwo();
            }
        }
        
        return car;
    }
    
    
    @Override
    public String toString() {
        return "the car engine is : " + this.engine;
    }
    
}


class TestOne{
    public static void main(String[] args) {
        System.out.println(MyCarTwo.getInstance() == MyCarTwo.getInstance());
    }
}


