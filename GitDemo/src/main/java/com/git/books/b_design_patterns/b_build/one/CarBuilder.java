package com.git.books.b_design_patterns.b_build.one;

/**
 * 
 * @Description: Car 建造车  最简单的模式 只有一个建造者
 * @author: songqinghu
 * @date: 2017年2月23日 下午2:18:52
 * Version:1.0
 */
public interface CarBuilder {
    
    public abstract void buildEngine();
    
    public abstract void buildTyre();
    
    public abstract Car buildCar();
}
