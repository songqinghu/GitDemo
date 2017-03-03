package com.git.books.b_design_patterns.h_composite.b;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 安全方式的树枝节点
 * @author: songqinghu
 * @date: 2017年3月3日 下午8:06:33
 * Version:1.0
 */
public class TwoGift implements TwoContainer{

    private List<TwoContainer> gifts = new ArrayList<>();
    
    public void show() {
        System.out.println("the gift is open !");
    }

    
    public void add(TwoContainer gift){
        gifts.add(gift);
    }
    
    public void remove(TwoContainer gift){
        gifts.remove(gift);
    }
    
    
    public void showAll(){
        for (TwoContainer gift : gifts) {
            gift.show();
        }
    }

    
    
}
