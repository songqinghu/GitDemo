package com.git.books.b_design_patterns.b_build.one;
/**
 * 
 * @Description: 宝马车建造者
 * @author: songqinghu
 * @date: 2017年2月23日 下午2:41:53
 * Version:1.0
 */
public class BMWCarBuilder implements CarBuilder {

    private BMWCar car = new BMWCar();
    
    @Override
    public void buildEngine() {
         car.setEngine(" bmw engine ");
    }

    @Override
    public void buildTyre() {
        car.setTyre(" bmw tyre ");
    }

    @Override
    public Car buildCar() {
        
        return this.car;
    }

}
