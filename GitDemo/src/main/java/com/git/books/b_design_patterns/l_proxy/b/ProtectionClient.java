package com.git.books.b_design_patterns.l_proxy.b;
/**
 * @Description: 保护代理测试类
 * @author: songqinghu
 * @date: 2017年3月8日 下午5:58:16
 * Version:1.0
 */
public class ProtectionClient {

    public static void main(String[] args) {
        
        ProtectionAccountInfoProxy proxy = new ProtectionAccountInfoProxy(new AccountInfo());
        
        proxy.showUserInfo("Admin");
        
        proxy.showUserInfo("ReadOnly");
        
    }
}
