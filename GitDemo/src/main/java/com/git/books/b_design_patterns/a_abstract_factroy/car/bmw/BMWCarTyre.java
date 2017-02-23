package com.git.books.b_design_patterns.a_abstract_factroy.car.bmw;

import com.git.books.b_design_patterns.a_abstract_factroy.car.CarTyre;

/**
 * 
 * @Description: 宝马车车轮胎
 * @author: songqinghu
 * @date: 2017年2月22日 下午3:48:39
 * Version:1.0
 */
public class BMWCarTyre extends CarTyre {

    public BMWCarTyre() {
        super("BMW");
    }

    @Override
    public void run() {
        System.out.println("the bmw car tyre is run !");
    }

}
