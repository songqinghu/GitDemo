package com.git.books.b_design_patterns.b_build.two;
/**
 * 
 * @Description: 手机建造者
 * @author: songqinghu
 * @date: 2017年2月23日 下午3:03:08
 * Version:1.0
 */
public class MobilePhoneBuilder {

    private MobilePhone phone = new MobilePhone();
    
    private MobilePhoneBuilder buildCPU(){
        phone.setCPU("四核");
        return this;
    }
    
    private MobilePhoneBuilder buildIndicator(){
        phone.setIndicator("防子弹");
        return this;
    }
    
    public MobilePhone build(){
        buildCPU().buildIndicator();
        return phone;
    }

}
