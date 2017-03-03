package com.git.books.b_design_patterns.h_composite.b;

public class TwoCompositeTest {

    public static void main(String[] args) {
        
        TwoContainer gifts = new TwoGift();
        
        gifts.add(new TwoClothes());
        
        gifts.add(new TwoPants());
        
        gifts.add(new TwoGift());
        
        gifts.showAll();
        
    }
}
