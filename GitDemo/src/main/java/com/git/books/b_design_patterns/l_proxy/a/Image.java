package com.git.books.b_design_patterns.l_proxy.a;

public class Image implements ImageProxy {

    @Override
    public void showImage() {
        try {
            
            System.out.println("start load image ! ");
            
            Thread.sleep(1000);
            
            System.out.println("end load iamge !");
            
        } catch (Exception e) {
            System.out.println("load image occor error !");
        }
    }

}
