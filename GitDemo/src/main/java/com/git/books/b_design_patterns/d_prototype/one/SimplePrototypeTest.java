package com.git.books.b_design_patterns.d_prototype.one;
/**
 * 
 * @Description: 浅复制原型模式调用类
 * @author: songqinghu
 * @date: 2017年2月27日 下午7:36:33
 * Version:1.0
 */
public class SimplePrototypeTest {

    public static void main(String[] args) {
        
        PrototypeBMWCar oneCar = new PrototypeBMWCar();
        
        PrototypeBMWCar twoCar = (PrototypeBMWCar) oneCar.deepClone();
        
        oneCar.run();
        twoCar.run();
        
        System.out.println(oneCar.getBrand() == twoCar.getBrand());
        
        System.out.println(oneCar == twoCar);
        
        System.out.println(oneCar.getEngine() == twoCar.getEngine());
        
    }
    
}
