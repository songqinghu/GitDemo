package com.git.books.b_design_patterns.a_abstract_factroy.car;
/**
 * 
 * @Description: 引擎类父类
 * @author: songqinghu
 * @date: 2017年2月22日 下午3:34:07
 * Version:1.0
 */
public abstract class CarEngine {

    public CarEngine(String name) {
        System.out.println("the "+name+" car engline is created!");
    }
    
    public abstract void start();
    
}
