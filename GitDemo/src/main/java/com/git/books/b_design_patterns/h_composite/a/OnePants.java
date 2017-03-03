package com.git.books.b_design_patterns.h_composite.a;

public class OnePants implements OneContainer {

    @Override
    public void open() {
        System.out.println(" this is Pants beautifu");
    }

    @Override
    public void simpleOpen() {
        System.out.println("is this Pants beautifu");
    }

}
