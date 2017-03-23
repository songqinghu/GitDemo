package com.git.books.b_design_patterns.s_observer;
/**
 * @Description: 散户观察者对事件做出反应
 * @author: songqinghu
 * @date: 2017年3月22日 下午4:57:25
 * Version:1.0
 */
public class Retail implements Investors {

    @Override
    public void update(PriceOfStock stock, ChangeEvent evnet) {
        if(ChangeEvent.rise.equals(evnet) && stock.getPrice()>10){
            System.out.println("the Retail Buy a lot of stock ");
        }else if(ChangeEvent.fall.equals(evnet) && stock.getPrice()<4){
            System.out.println("the Retail Sell a lot of stock");
        }else{
            System.out.println("the Retail Position");
        }
    }

}
