package com.git.books.b_design_patterns.i_decorator;
/**
 * @Description: 包装使之收获赞美
 * @author: songqinghu
 * @date: 2017年3月4日 下午3:49:10
 * Version:1.0
 */
public class PraiseDecorator extends PeopleDecorator {

    public PraiseDecorator(PeopleComponent component) {
        super(component);
    }

    @Override
    public void action() {
        if(people.getGender().equals(Gender.Man)){
            System.out.println("The man is handsome!");
        }else{
            System.out.println("This woman is charming!");
        }
    }

    @Override
    public void show() {
        component.show();
        action();
    }

}
