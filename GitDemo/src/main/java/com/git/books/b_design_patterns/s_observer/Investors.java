package com.git.books.b_design_patterns.s_observer;
/**
 * @Description: 股民 扮演观察者
 * @author: songqinghu
 * @date: 2017年3月22日 下午4:24:04
 * Version:1.0
 */
public interface Investors {

    public void update(PriceOfStock stock,ChangeEvent evnet);
}
