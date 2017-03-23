package com.git.books.b_design_patterns.t_state;

import java.util.Vector;

/**
 * @Description: 自动变化的交通灯 被观察者(简化抽象类)
 * @author: songqinghu
 * @date: 2017年3月23日 下午6:11:44
 * Version:1.0
 */
public class TrafficLights {

    private Vector<TrafficLightObserver>  observers  = new Vector<>();
    
    
    public void addObserver(TrafficLightObserver observer){
        observers.add(observer);
    }
    
    public void removeObserver(TrafficLightObserver observer){
        observers.remove(observer);
    }
    
    public void changeAll(State state){
        for (TrafficLightObserver observer : observers) {
            observer.changeState(state);
        }
    }
    
   
}
class  LightTime implements Runnable{

    
    private TrafficLights light;
    
    public LightTime(TrafficLights light) {
        this.light = light;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                light.changeAll(RedLight.getInstance());
                Thread.sleep(4000);
                light.changeAll(YellowLight.getInstance());
                Thread.sleep(1000);
                light.changeAll(GreenLight.getInstance());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}

