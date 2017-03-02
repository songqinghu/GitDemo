package com.git.books.b_design_patterns.g_bridge;
/**
 * 
 * @Description: 桥接模式测试类
 * @author: songqinghu
 * @date: 2017年3月2日 下午2:56:37
 * Version:1.0
 */
public class BridgeModelTestOne {

    public static void main(String[] args) {
        
        MobilePhone phone = new TwoCPUMobilePhone(new XiaomiBrand());
        
        phone.run();
        
        phone = new OneCPUMobilePhone(new HuaWeiBrand());
        
        phone.run();
        
    }
    
    
}
