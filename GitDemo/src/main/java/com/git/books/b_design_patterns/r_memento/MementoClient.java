package com.git.books.b_design_patterns.r_memento;

import java.util.Date;

/**
 * @Description: 测试类
 * @author: songqinghu
 * @date: 2017年3月20日 下午6:19:34
 * Version:1.0
 */
public class MementoClient {

    
    public static void main(String[] args) throws InterruptedException {
        
        TimeLine timeLine = new TimeLine(new Date());
        
        timeLine.showDate();
        
        God god = new God(timeLine);
        Thread.sleep(1000);
        //设置还原点
        god.mementoTime();
        
        timeLine.setDate(new Date());
        
        timeLine.showDate();
        //还原
        god.retoreTime();
        
        timeLine.showDate();
        
        
    }
    
    
    
}
