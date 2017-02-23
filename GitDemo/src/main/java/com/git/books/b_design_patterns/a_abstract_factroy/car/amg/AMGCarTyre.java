package com.git.books.b_design_patterns.a_abstract_factroy.car.amg;

import com.git.books.b_design_patterns.a_abstract_factroy.car.CarTyre;

/**
 * 
 * @Description: 奔驰车车轮胎
 * @author: songqinghu
 * @date: 2017年2月22日 下午3:49:58
 * Version:1.0
 */
public class AMGCarTyre extends CarTyre {

    public AMGCarTyre() {
        super("AMG");
    }

    @Override
    public void run() {
        System.out.println("the amg car tyre is run !");
    }

}
