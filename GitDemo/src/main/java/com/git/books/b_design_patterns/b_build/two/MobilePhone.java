package com.git.books.b_design_patterns.b_build.two;
/**
 * 
 * @Description: 手机实体类
 * @author: songqinghu
 * @date: 2017年2月23日 下午3:03:47
 * Version:1.0
 */
public class MobilePhone {

    private String CPU;
    
    private String indicator;

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String cPU) {
        CPU = cPU;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }
    
    public void light(){
        System.out.println("the phone is light and the cpu is : " + this.CPU + " and the indicator is "+this.indicator);
    }
    
}
