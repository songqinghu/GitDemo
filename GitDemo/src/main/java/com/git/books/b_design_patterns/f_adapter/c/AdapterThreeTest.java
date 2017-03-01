package com.git.books.b_design_patterns.f_adapter.c;
/**
 * 
 * @Description: 缺省模式适配器测试
 * @author: songqinghu
 * @date: 2017年3月1日 下午3:42:33
 * Version:1.0
 */
public class AdapterThreeTest {

    public static void main(String[] args) {
        
        EightDog eight = new EightDog();
        eight.call();
        eight.waitingMaster();
    }
    
}
