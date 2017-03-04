package com.git.books.b_design_patterns.i_decorator;
/**
 * 
 * @Description: 装饰模式 顶级定义类  对一个人进行装饰(穿衣)
 * @author: songqinghu
 * @date: 2017年3月4日 下午3:24:43
 * Version:1.0
 */
public abstract class PeopleComponent {

    protected People people;
    
    public void setPeople(People people){
        this.people = people;
    }
    public abstract void show();
    
}
