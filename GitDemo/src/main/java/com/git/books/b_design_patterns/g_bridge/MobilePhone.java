package com.git.books.b_design_patterns.g_bridge;
/**
 * 
 * @Description:桥接模式-抽象引用接口
 * @author: songqinghu
 * @date: 2017年3月2日 下午2:39:54
 * Version:1.0
 */
public abstract class MobilePhone {

    protected Brand brand;
    
    public abstract void run();
    
    
    public MobilePhone(Brand brand) {
        this.brand = brand;
    }
    
}
