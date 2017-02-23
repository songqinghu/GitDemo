package com.git.books.b_design_patterns.a_abstract_factroy.car.bmw;

import com.git.books.b_design_patterns.a_abstract_factroy.car.CarEngine;

/**
 * @Description: 宝马车引擎类
 * @author: songqinghu
 * @date: 2017年2月22日 下午3:36:23
 * Version:1.0
 */
public class BMWCarEngine extends CarEngine {

    
    public BMWCarEngine() {
        super("BMW");
    }

    @Override
    public void start() {
        System.out.println("the bmw car engine is start! ");
    }

}
