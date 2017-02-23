package com.git.books.b_design_patterns.a_abstract_factroy.car.amg;

import com.git.books.b_design_patterns.a_abstract_factroy.car.CarEngine;

/**
 * 
 * @Description: 奔驰发动机
 * @author: songqinghu
 * @date: 2017年2月22日 下午3:41:25
 * Version:1.0
 */
public class AMGCarEngine extends CarEngine {

    public AMGCarEngine() {
        super("AMG");
    }

    @Override
    public void start() {
        System.out.println("the amg car engine is start! ");
    }

}
