package com.git.books.b_design_patterns.s_observer;
/**
 * @Description: 观察者模式测试类
 * @author: songqinghu
 * @date: 2017年3月22日 下午5:02:10
 * Version:1.0
 */
public class ObserverClient {

    public static void main(String[] args) {
        
        GomePriceOfStock stock = new GomePriceOfStock("Gome", 9l);
        
        TheBanker banker = new TheBanker();
        Retail oneRetail = new Retail();
        Retail twoRetail = new Retail();
        
        stock.addObserver(banker);
        stock.addObserver(oneRetail);
        stock.addObserver(twoRetail);
        
        stock.change(ChangeEvent.rise);
        stock.change(ChangeEvent.rise);
        stock.change(ChangeEvent.rise);
        
    }
    
}
