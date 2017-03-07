package com.git.books.b_design_patterns.k_flyweight.b;

import javax.swing.text.AbstractDocument.BranchElement;

/**
 * @Description:咖啡叶子节点 需要咖啡品类状态
 * @author: songqinghu
 * @date: 2017年3月7日 下午7:32:52
 * Version:1.0
 */
public class CupCoffee implements Coffee {
    
    private CoffeeEnum coffeeBrand;

    public CupCoffee(CoffeeEnum coffeeBrand) {
        
        this.coffeeBrand = coffeeBrand;
    }
    
    @Override
    public void show(Table table) {
        
        System.out.println("this coffee brand is : " + coffeeBrand.toString() + "  and the table num is : " + table.getNumber());
    }

}
