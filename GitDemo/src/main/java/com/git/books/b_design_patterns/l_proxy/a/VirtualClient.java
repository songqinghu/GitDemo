package com.git.books.b_design_patterns.l_proxy.a;
/**
 * @Description: 测试客户端  加载时间过久,等到需要时候再进行加载
 * @author: songqinghu
 * @date: 2017年3月8日 下午5:35:23
 * Version:1.0
 */
public class VirtualClient {

    public static void main(String[] args) {
        
        
        VirtualImageProxy proxy = new VirtualImageProxy();
        
        System.out.println(proxy.getHeight());
        
        proxy.showImage();
        
    }
}
