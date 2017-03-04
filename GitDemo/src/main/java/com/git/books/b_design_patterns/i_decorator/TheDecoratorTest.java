package com.git.books.b_design_patterns.i_decorator;
/**
 * 
 * @Description: 装饰模式测试类
 * @author: songqinghu
 * @date: 2017年3月4日 下午3:53:58
 * Version:1.0
 */
public class TheDecoratorTest {

    public static void main(String[] args) {
        People people = new People();
        people.setName("Coco");
        people.setAge(19);
        people.setGender(Gender.Woman);
        PeopleComponent peopleComponent = new PeopleConcrete(people);
        peopleComponent =new ClothesDecorator(new PantsDecorator(new  PraiseDecorator(peopleComponent)));
        peopleComponent.show();
        
    }
}
