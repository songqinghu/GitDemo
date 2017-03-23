package com.git.books.b_design_patterns.t_state;
/**
 * @Description:交通灯观察者
 * @author: songqinghu
 * @date: 2017年3月23日 下午6:12:45
 * Version:1.0
 */
public interface TrafficLightObserver {

    public void changeState(State state);
    
}
