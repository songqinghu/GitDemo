package com.git.books.b_design_patterns.p_iterator;

public class BackwardMyIterator implements MyIterator<SomeThing> {

    private ShoppingCart shop;
    
    private int state;
    
    public BackwardMyIterator(ShoppingCart shop) {
        this.shop = shop;
        first();
    }
    
    @Override
    public SomeThing next() {
        if(!isDone()){
            SomeThing thing = shop.currentThing(state);
            state--;
            return thing;
        }else{
            throw new RuntimeException("the thing is over!");
        }
        
    }

    @Override
    public void first() {
        state = shop.count()-1;
    }

    @Override
    public boolean isDone() {
        return state <0;
    }

}
