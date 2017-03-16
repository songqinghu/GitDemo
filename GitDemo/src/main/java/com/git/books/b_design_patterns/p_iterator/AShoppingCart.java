package com.git.books.b_design_patterns.p_iterator;

public class AShoppingCart extends ShoppingCart {

    @Override
    public MyIterator<SomeThing> createIterator() {
        return new ForwardMyIterator(this);
    }

    
}
