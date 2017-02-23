package com.git.books.b_design_patterns.b_build.one;
/**
 * 
 * @Description: 奔驰车建造者
 * @author: songqinghu
 * @date: 2017年2月23日 下午2:42:16
 * Version:1.0
 */
public class AWGCarBuilder implements CarBuilder {

    private AWGCar car = new AWGCar();
    
    @Override
    public void buildEngine() {
         car.setEngine(" awg engine ");
    }

    @Override
    public void buildTyre() {
        car.setTyre(" awg tyre ");
    }

    @Override
    public Car buildCar() {
        
        return this.car;
    }


}
