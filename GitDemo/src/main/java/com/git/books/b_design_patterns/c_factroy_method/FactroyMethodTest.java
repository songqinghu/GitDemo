package com.git.books.b_design_patterns.c_factroy_method;

import com.git.books.b_design_patterns.b_build.one.Car;

public class FactroyMethodTest {

    public static void main(String[] args) {
        
        //生产宝马车
        CarFactroyMethod factroy = new BMWCarFactroyMethod();
        
        Car car = factroy.createCar();
        
        car.run();
        
        //生产奔驰车
        factroy = new AWGCarFactroyMethod();
        
        car = factroy.createCar();
        
        car.run();
        
        
        
        
        
    }
}
