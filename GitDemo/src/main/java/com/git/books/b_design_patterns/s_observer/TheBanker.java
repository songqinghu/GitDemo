package com.git.books.b_design_patterns.s_observer;
/**
 * @Description: 庄家观察者 对事件做出相应的反应
 * @author: songqinghu
 * @date: 2017年3月22日 下午4:56:12
 * Version:1.0
 */
public class TheBanker implements Investors {

    @Override
    public void update(PriceOfStock stock, ChangeEvent evnet) {
        if(ChangeEvent.rise.equals(evnet) && stock.getPrice()>10){
            System.out.println("the banker Sell a lot of stock");
        }else if(ChangeEvent.fall.equals(evnet) && stock.getPrice()<4){
            System.out.println("the banker Buy a lot of stock");
        }else{
            System.out.println("the banker Position");
        }
    }

}
