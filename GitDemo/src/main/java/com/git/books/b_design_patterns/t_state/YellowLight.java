package com.git.books.b_design_patterns.t_state;

/**
 * @Description: 黄灯
 * @author: songqinghu
 * @date: 2017年3月23日 下午6:03:20
 * Version:1.0
 */
public class YellowLight implements State {

    
    private static  class YellowInner{
        private final static YellowLight yellow = new YellowLight();
    }
    
    public static YellowLight getInstance(){
        return YellowInner.yellow;
    }
    
    @Override
    public void active() {
        System.out.println("the car Forward OR  wait ");
    }

}
