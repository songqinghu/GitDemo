package com.git.books.b_design_patterns.t_state;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description: 状态模式测试类
 * @author: songqinghu
 * @date: 2017年3月23日 下午6:59:22
 * Version:1.0
 */
public class StateClient {

    public static void main(String[] args) {
        
        TrafficLights light = new TrafficLights();
        
        Car one = new Car();
        
        Car two = new Car();
        
        light.addObserver(one);
        light.addObserver(two);
        
        LightTime lightTime = new LightTime(light);
        lightTime.run();
    }
    
}
