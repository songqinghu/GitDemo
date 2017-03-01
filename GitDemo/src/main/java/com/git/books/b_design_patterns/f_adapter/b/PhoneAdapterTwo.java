package com.git.books.b_design_patterns.f_adapter.b;

import com.git.books.b_design_patterns.f_adapter.a.GlassAdaptee;
import com.git.books.b_design_patterns.f_adapter.a.PhoneTarget;

public class PhoneAdapterTwo implements PhoneTarget{
    
    private GlassAdaptee adaptee;
    
    public PhoneAdapterTwo(GlassAdaptee adaptee) {
        this.adaptee = adaptee;

    }
    
    @Override
    public void holdWater() {
        adaptee.holdWater();
    }

    @Override
    public void light() {
        System.out.println("the phone is light!");
    }
    
    
    
    
}
