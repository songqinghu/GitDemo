package com.git.books.b_design_patterns.a_abstract_factroy.car.amg;

import com.git.books.b_design_patterns.a_abstract_factroy.car.CarAbstractFactroy;
import com.git.books.b_design_patterns.a_abstract_factroy.car.CarEngine;
import com.git.books.b_design_patterns.a_abstract_factroy.car.CarTyre;

/**
 * 
 * @Description: 奔驰车组件工厂类
 * @author: songqinghu
 * @date: 2017年2月22日 下午3:55:24
 * Version:1.0
 */
public class AMGCarFactroy implements CarAbstractFactroy {

    @Override
    public CarEngine createCarEngine() {
        return new AMGCarEngine();
    }

    @Override
    public CarTyre createCarTyre() {
        return new AMGCarTyre();
    }

}
