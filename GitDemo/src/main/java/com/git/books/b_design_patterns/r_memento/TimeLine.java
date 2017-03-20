package com.git.books.b_design_patterns.r_memento;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:时光轴 表示备忘录中的原发器
 * @author: songqinghu
 * @date: 2017年3月20日 下午6:01:31
 * Version:1.0
 */
public class TimeLine {

    private Date date;
    
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    public TimeLine(Date date) {
        this.date = date;
    }
    
    public Coordinate createMemento(){
        return new TimeMachine(this.date);
    }
    
    public void restoreMemento(Coordinate co){
        setDate(((TimeMachine)co).getDate());
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void showDate(){
        System.out.println(format.format(getDate()));
    }


    /**
     * @Description: 时光机 用于存于状态 
     * @author: songqinghu
     * @date: 2017年3月20日 下午6:07:38
     * Version:1.0
     */
    class TimeMachine implements Coordinate{
        
        private Date date;
        
        public TimeMachine(Date date) {
            this.date = date;
        }

        private Date getDate() {
            return date;
        }

//        private void setDate(Date date) {
//            this.date = date;
//        }
        
    }
    
    
}
