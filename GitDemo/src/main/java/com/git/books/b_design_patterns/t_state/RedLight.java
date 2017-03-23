package com.git.books.b_design_patterns.t_state;
/**
 * @Description: 红灯
 * @author: songqinghu
 * @date: 2017年3月23日 下午6:03:20
 * Version:1.0
 */
public class RedLight implements State {

    
    private static  class RedInner{
        private final static RedLight red = new RedLight();
    }
    
    public static RedLight getInstance(){
        return RedInner.red;
    }
    
    @Override
    public void active() {
        System.out.println("the car  wait ");
    }

}
