package com.git.books.b_design_patterns.b_build.two;
/**
 * 
 * @Description: 简单的建造者模式测试类
 * @author: songqinghu
 * @date: 2017年2月23日 下午3:19:15
 * Version:1.0
 */
public class SimpleBuilderPatternTest {

    
    public static void main(String[] args) {
        
        MobilePhone phone = new MobilePhoneBuilder().build();
        
        phone.light();
        
    }
    
    
}
