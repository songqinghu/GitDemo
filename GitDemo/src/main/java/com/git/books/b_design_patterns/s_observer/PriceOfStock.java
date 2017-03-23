package com.git.books.b_design_patterns.s_observer;

import java.util.Vector;
/**
 * @Description: 股价抽象类 扮演被观察者
 * @author: songqinghu
 * @date: 2017年3月22日 下午4:21:10
 * Version:1.0
 */
public abstract class PriceOfStock {

    private String name;//股票名称
    
    private Long price;//股票价格
    
    public PriceOfStock(String name,Long price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }



    public Vector<Investors> observers = new Vector<>();
    
    public  void addObserver(Investors investors){
        observers.add(investors);
    }
    
    public void removeObserver(Investors investors){
        observers.remove(investors);
    }
    
    public void notifyAll(ChangeEvent  event){
        for (Investors investors : observers) {
            investors.update(this, event);
        }
    }
    
    public abstract void change(ChangeEvent  event);
    
}
