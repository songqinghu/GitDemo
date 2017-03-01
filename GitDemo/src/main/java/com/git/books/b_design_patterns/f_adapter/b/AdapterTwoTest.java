package com.git.books.b_design_patterns.f_adapter.b;

import com.git.books.b_design_patterns.f_adapter.a.GlassAdaptee;

/**
 * 
 * @Description: 对象类型适配器模式测试
 * @author: songqinghu
 * @date: 2017年3月1日 下午3:16:41
 * Version:1.0
 */
public class AdapterTwoTest {
    
    
    public static void main(String[] args) {
        
        PhoneAdapterTwo adapter = new PhoneAdapterTwo(new GlassAdaptee());
        
        adapter.holdWater();
        adapter.light();
        
        
    }

}
