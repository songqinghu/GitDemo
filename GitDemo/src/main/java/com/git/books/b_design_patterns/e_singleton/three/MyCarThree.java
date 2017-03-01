package com.git.books.b_design_patterns.e_singleton.three;

/**
 * 
 * @Description: 双重校验模式 懒汉式单例模式   --JVM无序写入导致存在问题
 * @author: songqinghu
 * @date: 2017年2月28日 下午2:09:01
 * Version:1.0
 */
public class MyCarThree {

    
    private static volatile MyCarThree  car;
    
    
    private String engine;
    
    
    private MyCarThree(){
        engine="BMW";
    }
    
    
    public static MyCarThree getInstance(){
        
        if(car ==null){
            synchronized (MyCarThree.class) {
                if(car ==null){
                    car = new MyCarThree();
                }
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
        System.out.println(MyCarThree.getInstance() == MyCarThree.getInstance());
    }
}


