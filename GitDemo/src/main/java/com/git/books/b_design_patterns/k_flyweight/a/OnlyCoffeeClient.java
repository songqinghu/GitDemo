package com.git.books.b_design_patterns.k_flyweight.a;

import java.util.ArrayList;

/**
 * 
 * @Description: 测试无外部状态享元模式
 * @author: songqinghu
 * @date: 2017年3月7日 下午7:56:17
 * Version:1.0
 */
public class OnlyCoffeeClient {

    
    public static void main(String[] args) {
        
        ArrayList<OnlyCoffeeEnum> coffeeEnums = new ArrayList<OnlyCoffeeEnum>();
        
        coffeeEnums.add(OnlyCoffeeEnum.BlueMountain);
        coffeeEnums.add(OnlyCoffeeEnum.CharcoalCoffee);        
        coffeeEnums.add(OnlyCoffeeEnum.DecaffeinatedCoffee);        
        coffeeEnums.add(OnlyCoffeeEnum.BlueMountain);        
        
        OnlyCoffeeTree tree = OnlyFlyWeightFactory.getInstance().createCoffees(coffeeEnums);
        tree.show();
        
        System.out.println(OnlyFlyWeightFactory.getInstance().getCoffeeBrandNum());
        
        OnlyCoffee coffee = OnlyFlyWeightFactory.getInstance().createCoffee(OnlyCoffeeEnum.CharcoalCoffee);
        coffee.show();
        
        System.out.println(OnlyFlyWeightFactory.getInstance().getCoffeeBrandNum());
        
        
        
        
        
        
        
    }
    
    
    
    
    
}
