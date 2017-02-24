package com.git.books.b_design_patterns.c_factroy_method;

import com.git.books.b_design_patterns.b_build.one.AWGCarBuilder;
import com.git.books.b_design_patterns.b_build.one.Car;
import com.git.books.b_design_patterns.b_build.one.CarDirector;
/**
 * 
 * @Description: 奔驰车工厂 生产奔驰车
 * @author: songqinghu
 * @date: 2017年2月24日 下午2:44:50
 * Version:1.0
 */
public class AWGCarFactroyMethod implements CarFactroyMethod {

    @Override
    public Car createCar() {
        return new CarDirector(new AWGCarBuilder()).build();
    }

}
