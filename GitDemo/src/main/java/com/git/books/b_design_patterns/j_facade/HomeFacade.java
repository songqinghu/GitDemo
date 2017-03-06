package com.git.books.b_design_patterns.j_facade;
/**
 * @Description: 家庭门面模式:假设家庭系统中有两个复杂的操作过程:回家和离家
 *               1.回家需要 打开门,关门,开灯,开热水器,洗澡,睡觉
 *               2.离家需要 起床,关闭热水器,关灯,开门,关门
 * @author: songqinghu
 * @date: 2017年3月6日 下午2:36:18
 * Version:1.0
 */
public class HomeFacade {

    private Door door;
    
    private Light light;
    
    private Heater heater;
    
    private Bed bed;
    
    public  HomeFacade(){
        door = new Door();
        
        light = new Light();
        
        heater = new Heater();
        
        bed = new Bed();
    }
    
    
    /**
     * @描述：回家的门面封装  后期可能比较复杂 如周一做什么,周二什么...这些客户都后不需要去过问具体的操作一般的情况下
     * @return void
     * @createTime：2017年3月6日
     * @author: songqinghu
     */
    public void goHome(){
        door.openDoor();
        door.closeDoor();
        light.openLight();
        heater.openHeater();
        heater.bathe();
        bed.sleep();
    }
    
    public void leaveHome(){
        bed.getUp();
        heater.closeHeater();
        light.closeLight();
        door.openDoor();
        door.closeDoor();
    }
    
}
