package com.git.books.b_design_patterns.a_abstract_factroy;
/**
 * 
 * @Description: 自行车类
 * @author: songqinghu
 * @date: 2017年2月21日 下午9:11:25
 * Version:1.0
 */
public class Bicycle extends Vehicle {

    public Bicycle() {
        
        System.out.println(" the Bicycle  is created!");
        
    }

    @Override
    public void run() {
        
        System.out.println("the Bicycle is run !");
    }
    
    
    
    
}
