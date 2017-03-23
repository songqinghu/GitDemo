
package com.git.books.b_design_patterns.s_observer;
/**
 * @Description: 具体被观察者
 * @author: songqinghu
 * @date: 2017年3月22日 下午4:55:27
 * Version:1.0
 */
public class GomePriceOfStock extends PriceOfStock {

    public GomePriceOfStock(String name, Long price) {
        super(name, price);
    }

    @Override
    public void change(ChangeEvent event) {
        if(ChangeEvent.rise.equals(event)){
            setPrice(getPrice() + 1);
        }else{
            setPrice(getPrice() - 1);
        }
        notifyAll(event);
    }

}
