package com.git.books.b_design_patterns.t_state;
/**
 * @Description: 汽车类 根据不同红绿灯状态发生不同的行为  这里可以加上观察者模式
 * @author: songqinghu
 * @date: 2017年3月23日 下午5:57:40
 * Version:1.0
 */
public class Car implements TrafficLightObserver{

    private State state;
    
    public  void active(){
        state.active();
    }
    
    public void changeState(State state){
        this.state = state;
        active();
    }
    
}
