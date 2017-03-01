package com.git.books.b_design_patterns.f_adapter.a;

public class PhoneAdapter extends GlassAdaptee implements PhoneTarget {


    @Override
    public void light() {
        System.out.println("the phone is light!");
    }

}
