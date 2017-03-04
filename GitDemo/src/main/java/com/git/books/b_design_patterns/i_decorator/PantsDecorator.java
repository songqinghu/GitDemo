package com.git.books.b_design_patterns.i_decorator;
/**
 * @Description: 包装 使之穿上裤子
 * @author: songqinghu
 * @date: 2017年3月4日 下午3:47:51
 * Version:1.0
 */
public class PantsDecorator extends PeopleDecorator {
    
    public PantsDecorator(PeopleComponent component) {
        super(component);
    }

    @Override
    public void action() {
        System.out.println(people.getName() + " put on a beautiful pants");
    }

    @Override
    public void show() {
        action();
        component.show();
    }

}
