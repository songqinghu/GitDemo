package com.git.books.b_design_patterns.k_flyweight.a;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.iterators.ArrayListIterator;

/**
 * @Description: 组合模式 树枝节点
 * @author: songqinghu
 * @date: 2017年3月7日 下午7:40:55
 * Version:1.0
 */
public class OnlyCoffeeTree implements OnlyCoffee {
    
    private List<OnlyCoffee> coffees = new ArrayList<>();
    
    @Override
    public void show() {
        for (OnlyCoffee coffee : coffees) {
            coffee.show();
        }
    }

    public void addCoffee(OnlyCoffee coffee){
        coffees.add(coffee);
    }

}
