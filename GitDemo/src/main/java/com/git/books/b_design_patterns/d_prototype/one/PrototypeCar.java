package com.git.books.b_design_patterns.d_prototype.one;

import java.io.Serializable;

/**
 * 
 * @Description: 浅拷贝父类
 * @author: songqinghu
 * @date: 2017年2月27日 下午7:23:32
 * Version:1.0
 */
public interface PrototypeCar extends Cloneable,Serializable {
    
    public abstract void run();
    
}
