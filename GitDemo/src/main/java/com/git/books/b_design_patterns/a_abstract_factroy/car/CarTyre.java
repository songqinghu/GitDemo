package com.git.books.b_design_patterns.a_abstract_factroy.car;
/**
 * 
 * @Description: 车胎类父类
 * @author: songqinghu
 * @date: 2017年2月22日 下午3:43:55
 * Version:1.0
 */
public abstract class CarTyre {

    public CarTyre(String name) {
        
        System.out.println("the "+ name +"car tyre is created! ");
    
    }
    
    public abstract void run();
    
}
