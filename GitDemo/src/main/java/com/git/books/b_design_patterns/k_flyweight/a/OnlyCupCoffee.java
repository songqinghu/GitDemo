package com.git.books.b_design_patterns.k_flyweight.a;
/**
 * @Description:咖啡叶子节点 需要咖啡品类状态
 * @author: songqinghu
 * @date: 2017年3月7日 下午7:32:52
 * Version:1.0
 */
public class OnlyCupCoffee implements OnlyCoffee {
    
    private OnlyCoffeeEnum coffeeBrand;

    public OnlyCupCoffee(OnlyCoffeeEnum coffeeBrand) {
        
        this.coffeeBrand = coffeeBrand;
    }
    
    @Override
    public void show() {
        
        System.out.println("this coffee brand is : " + coffeeBrand.toString());
    }

}
