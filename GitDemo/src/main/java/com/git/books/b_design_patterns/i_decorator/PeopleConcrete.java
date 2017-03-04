package com.git.books.b_design_patterns.i_decorator;
/**
 * @Description: 被装饰的实例类
 * @author: songqinghu
 * @date: 2017年3月4日 下午3:31:01
 * Version:1.0
 */
public class PeopleConcrete extends PeopleComponent {
    
    public PeopleConcrete(People people) {
        super();
        setPeople(people);
    }
    
    @Override
    public void show() {
        System.out.println(people.toString());
    }

}
