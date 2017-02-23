package com.git.books.b_design_patterns.a_abstract_factroy.car.bmw;

import com.git.books.b_design_patterns.a_abstract_factroy.car.CarAbstractFactroy;
import com.git.books.b_design_patterns.a_abstract_factroy.car.CarEngine;
import com.git.books.b_design_patterns.a_abstract_factroy.car.CarTyre;

/**
 * @Description: 宝马车组件生产类
 * @author: songqinghu
 * @date: 2017年2月22日 下午3:57:58
 * Version:1.0
 */
public class BMWCarFactroy implements CarAbstractFactroy {

    @Override
    public CarEngine createCarEngine() {
        return new BMWCarEngine();
    }

    @Override
    public CarTyre createCarTyre() {
        return new BMWCarTyre();
    }

}
