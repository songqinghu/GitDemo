package com.git.books.b_design_patterns.p_iterator;

import java.util.Vector;

/**
 * 购物车抽象类
 */
public abstract class ShoppingCart {
    
    private Vector<SomeThing> things = new Vector<>();

    public abstract MyIterator<SomeThing> createIterator();
    
    
    public int count(){
        return things.size();
    }
    
     SomeThing currentThing(int index){
        return things.get(index);
    }
    
    public void addThing(SomeThing thing){
        things.add(thing);
    }
    
    public void remove(SomeThing thing){
        things.remove(thing);
    }
    
    
}
