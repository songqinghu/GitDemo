package com.git.books.b_design_patterns.i_decorator;
/**
 * 
 * @Description: 装饰类接口定义类
 * @author: songqinghu
 * @date: 2017年3月4日 下午3:34:39
 * Version:1.0
 */
public abstract class PeopleDecorator extends PeopleComponent {
    
    protected PeopleComponent component;
    
    public PeopleDecorator(PeopleComponent component) {
        this.component = component;
        this.people = component.people;
    }

    //简单定义装饰行为
    public abstract void action();
    
}
