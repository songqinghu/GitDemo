package com.git.books.b_design_patterns.h_composite.a;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 安全方式的树枝节点
 * @author: songqinghu
 * @date: 2017年3月3日 下午8:06:33
 * Version:1.0
 */
public class OneGift implements OneContainer{

    private List<OneContainer> gifts = new ArrayList<>();
    
    @Override
    public void open() {
        System.out.println("the gift is open !");
    }

    @Override
    public void simpleOpen() {
        System.out.println("Are you ready!");
    }

    
    public void add(OneContainer gift){
        gifts.add(gift);
    }
    
    public void remove(OneContainer gift){
        gifts.remove(gift);
    }
    
    
    public void showAllGift(){
        for (OneContainer gift : gifts) {
            gift.open();
        }
    }
    
    
}
