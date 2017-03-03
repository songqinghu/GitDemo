package com.git.books.b_design_patterns.h_composite.a;

public class OneCompositeTest {

    public static void main(String[] args) {
        
        OneGift gift = new OneGift();
        
        gift.add(new OneClothes());
        
        gift.add(new OnePants());
        
        gift.add(new OneGift());
        
        gift.showAllGift();
        
    }
}
