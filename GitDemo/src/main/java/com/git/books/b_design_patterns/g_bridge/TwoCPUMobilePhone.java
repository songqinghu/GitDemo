package com.git.books.b_design_patterns.g_bridge;

public class TwoCPUMobilePhone extends MobilePhone {

    public TwoCPUMobilePhone(Brand brand) {
        super(brand);
    }

    @Override
    public void run() {
        System.out.println("the two cpu "+brand.getBrandLogo()+" mobile phone is run !");
    }

}
