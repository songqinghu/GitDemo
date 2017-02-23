package com.git.books.b_design_patterns.b_build.one;

/**
 * 
 * @Description: Car 建造过程中的导演者  起到包装解耦作用
 * @author: songqinghu
 * @date: 2017年2月23日 下午2:49:16
 * Version:1.0
 */
public class CarDirector {
    
    private CarBuilder builder;
    
    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }
    
    public Car build(){
        builder.buildEngine();
        builder.buildTyre();
        return builder.buildCar();
    }
}
