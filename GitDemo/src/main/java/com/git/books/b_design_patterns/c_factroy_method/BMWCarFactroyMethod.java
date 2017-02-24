package com.git.books.b_design_patterns.c_factroy_method;

import com.git.books.b_design_patterns.b_build.one.BMWCarBuilder;
import com.git.books.b_design_patterns.b_build.one.Car;
import com.git.books.b_design_patterns.b_build.one.CarDirector;
/**
 * 
 * @Description: 宝马车工厂类 生产宝马车
 * @author: songqinghu
 * @date: 2017年2月24日 下午2:43:54
 * Version:1.0
 */
public class BMWCarFactroyMethod implements CarFactroyMethod {

    @Override
    public Car createCar() {
        return new CarDirector(new BMWCarBuilder()).build();
    }

}
