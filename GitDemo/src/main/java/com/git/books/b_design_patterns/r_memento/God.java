package com.git.books.b_design_patterns.r_memento;
/**
 * @Description: 上帝 负责人角色 有能力控制时间
 * @author: songqinghu
 * @date: 2017年3月20日 下午6:13:42
 * Version:1.0
 */
public class God {

    private TimeLine timeLine;
    
    private Coordinate co;
    
    public God(TimeLine timeLine) {
        this.timeLine = timeLine;
    }
    
    public void mementoTime(){
        co = timeLine.createMemento();
    }
    
    public void retoreTime(){
        timeLine.restoreMemento(co);
    }
    
    
}
