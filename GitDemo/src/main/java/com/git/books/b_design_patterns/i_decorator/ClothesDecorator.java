package com.git.books.b_design_patterns.i_decorator;
/**
 * 
 * @Description: 包装 使之穿上衣服
 * @author: songqinghu
 * @date: 2017年3月4日 下午3:47:21
 * Version:1.0
 */
public class ClothesDecorator extends PeopleDecorator {


    public ClothesDecorator(PeopleComponent component) {
        super(component);
    }

    @Override
    public void action() {
        System.out.println(people.getName() + " put on a beautiful dress");
    }

    @Override
    public void show() {
        action();
        component.show();
    }

}
