package com.git.books.b_design_patterns.h_composite.a;

public class OneClothes implements OneContainer {

    @Override
    public void open() {
        System.out.println(" this is dress beautifu");
    }

    @Override
    public void simpleOpen() {
        System.out.println("is this dress beautifu");
    }

}
