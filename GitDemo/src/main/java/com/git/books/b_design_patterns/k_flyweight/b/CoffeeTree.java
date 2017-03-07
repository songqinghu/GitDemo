package com.git.books.b_design_patterns.k_flyweight.b;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.iterators.ArrayListIterator;

/**
 * @Description: 组合模式 树枝节点
 * @author: songqinghu
 * @date: 2017年3月7日 下午7:40:55
 * Version:1.0
 */
public class CoffeeTree implements Coffee {
    
    private List<Coffee> coffees = new ArrayList<>();
    
    private List<Table> tables = new ArrayList<>();
    
    
    @Override
    public void show(Table table) {
        show();
    }
    public void show(){
        for (int i = 0; i < coffees.size(); i++) {
            coffees.get(i).show(tables.get(i));
        } 
    }

    public void addCoffee(Coffee coffee){
        coffees.add(coffee);
    }
    
    public void addTable(Table table){
        tables.add(table);
    }

}
