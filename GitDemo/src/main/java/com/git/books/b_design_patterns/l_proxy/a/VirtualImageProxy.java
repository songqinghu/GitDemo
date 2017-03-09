package com.git.books.b_design_patterns.l_proxy.a;

/**
 * @Description: 图片虚拟代理
 * @author: songqinghu
 * @date: 2017年3月8日 下午4:31:24
 * Version:1.0
 */
public class VirtualImageProxy implements ImageProxy{

    private int height = 100;
    
    private int width = 200;
    
    @Override
    public void showImage() {
        Image image = new Image();
        image.showImage();
    }

    public int getHeight() {
        return height;
    }

    
    public int getWidth() {
        return width;
    }


}
