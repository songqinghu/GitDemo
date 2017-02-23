package com.git.books.b_design_patterns.a_abstract_factroy;

import com.git.books.b_design_patterns.a_abstract_factroy.car.CarAbstractFactroy;
import com.git.books.b_design_patterns.a_abstract_factroy.car.CarEngine;
import com.git.books.b_design_patterns.a_abstract_factroy.car.CarTyre;
import com.git.books.b_design_patterns.a_abstract_factroy.car.amg.AMGCarFactroy;
import com.git.books.b_design_patterns.a_abstract_factroy.car.bmw.BMWCarFactroy;

/**
 * 
 * @Description: 测试工厂类
 * @author: songqinghu
 * @date: 2017年2月22日 下午4:01:00
 * Version:1.0
 */
public class CarTestFactroy {

    
    public static void main(String[] args) {
        
        //生产宝马车
        CarAbstractFactroy factroy = new BMWCarFactroy();
        
        createCar(factroy);
        
        //生产奔驰车
        factroy = new AMGCarFactroy();
   
        createCar(factroy);
    }
    
    
    public static void createCar(CarAbstractFactroy factroy){
        
        CarEngine engine = factroy.createCarEngine();
        
        CarTyre tyre = factroy.createCarTyre();
        
        engine.start();
        tyre.run();
        
    }
    
    
    
}
