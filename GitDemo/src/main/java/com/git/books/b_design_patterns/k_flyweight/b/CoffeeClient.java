package com.git.books.b_design_patterns.k_flyweight.b;

import java.util.ArrayList;

/**
 * 
 * @Description: 测试无外部状态享元模式
 * @author: songqinghu
 * @date: 2017年3月7日 下午7:56:17
 * Version:1.0
 */
public class CoffeeClient {

    
    public static void main(String[] args) {
        
        ArrayList<CoffeeEnum> coffeeEnums = new ArrayList<CoffeeEnum>();
        
        coffeeEnums.add(CoffeeEnum.BlueMountain);
        coffeeEnums.add(CoffeeEnum.CharcoalCoffee);        
        coffeeEnums.add(CoffeeEnum.DecaffeinatedCoffee);        
        coffeeEnums.add(CoffeeEnum.BlueMountain); 
        int num = 0;
        ArrayList<Table> tables = new ArrayList<Table>();
        for (int i = 0; i <coffeeEnums.size(); i++) {
            tables.add(new Table(i));
            num = i;
        }
        
        CoffeeTree tree = FlyWeightFactory.getInstance().createCoffees(coffeeEnums,tables);
        tree.show();
        
        System.out.println(FlyWeightFactory.getInstance().getCoffeeBrandNum());
        
        Coffee coffee = FlyWeightFactory.getInstance().createCoffee(CoffeeEnum.CharcoalCoffee);
        
        coffee.show(new Table(num+2));
        
        System.out.println(FlyWeightFactory.getInstance().getCoffeeBrandNum());
        
        
    }
    
    
    
    
    
}
