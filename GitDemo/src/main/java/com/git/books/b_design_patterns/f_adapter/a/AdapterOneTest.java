package com.git.books.b_design_patterns.f_adapter.a;
/**
 * @Description:类类型适配器模式测试
 * @author: songqinghu
 * @date: 2017年3月1日 下午3:16:17
 * Version:1.0
 */
public class AdapterOneTest {

    public static void main(String[] args) {
        
        PhoneAdapter adapter = new PhoneAdapter();
        adapter.light();
        adapter.holdWater();
        
    }
}
