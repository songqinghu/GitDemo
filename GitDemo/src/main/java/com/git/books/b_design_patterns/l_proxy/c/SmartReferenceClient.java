package com.git.books.b_design_patterns.l_proxy.c;
/**
 * @Description: 智能指引测试类
 * @author: songqinghu
 * @date: 2017年3月8日 下午6:28:21
 * Version:1.0
 */
public class SmartReferenceClient {

    public static void main(String[] args) {
        
        AccessTimes proxy = new SmartReferenceAccessTimesProxy(new AccessTimesProxy());
        
        proxy.access();
        proxy.access();
        proxy.access();
        proxy.access();
        proxy.access();
        
        System.out.println("访问次数: "+AccessCount.getInstance().getCountNum());
    }
}
