package com.git.books.b_design_patterns.p_iterator;
/**
 * @Description: 向前的迭代器
 * @author: songqinghu
 * @date: 2017年3月16日 下午2:47:25
 * Version:1.0
 */
public class ForwardMyIterator implements MyIterator<SomeThing>{

    private ShoppingCart shop;
    private int state;
    
    public ForwardMyIterator(ShoppingCart shop) {
        this.shop = shop;
        first();
    }
    
    @Override
    public SomeThing next() {
        
        if(!isDone()){
            SomeThing thing = shop.currentThing(state);
            state++;
            return thing;
        }else{
            throw new RuntimeException("the thing is over!");
        }
    }

    @Override
    public void first() {
        state=0;
    }

    @Override
    public boolean isDone() {
        return !(state <shop.count());
    }

}
