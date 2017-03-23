package com.git.books.b_design_patterns.t_state;

/**
 * @Description: 绿灯
 * @author: songqinghu
 * @date: 2017年3月23日 下午6:03:20
 * Version:1.0
 */
public class GreenLight implements State {

    
    
    private static  class GreenInner{
        private final static GreenLight green = new GreenLight();
    }
    
    public static GreenLight getInstance(){
        return GreenInner.green;
    }
    
    
    
    @Override
    public void active() {
        System.out.println("the car Forward");
    }

}
