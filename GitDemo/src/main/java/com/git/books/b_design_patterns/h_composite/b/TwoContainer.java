package com.git.books.b_design_patterns.h_composite.b;
/**
 * 
 * @Description: 透明方式的组合模式
 * @author: songqinghu
 * @date: 2017年3月3日 下午8:22:07
 * Version:1.0
 */
public interface TwoContainer {

    public void show();
    
    public void add(TwoContainer gift);
    
    public void remove(TwoContainer gift);
    
    public void showAll();
    
}
