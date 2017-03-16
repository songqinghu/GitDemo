package com.git.books.b_design_patterns.p_iterator;

public class IteratorClient {

    public static void main(String[] args) {
        ShoppingCart aShop = new AShoppingCart();
        aShop.addThing(new SomeThing("洗衣机"));
        aShop.addThing(new SomeThing("电视"));
        aShop.addThing(new SomeThing("冰箱"));
        aShop.addThing(new SomeThing("自行车"));
        
        MyIterator<SomeThing> aIterator = aShop.createIterator();
        while (!aIterator.isDone()) {
            System.out.println(aIterator.next());
        }
        System.out.println("======分割线======");
        ShoppingCart bShop = new BShoppingCart();
        bShop.addThing(new SomeThing("洗衣机"));
        bShop.addThing(new SomeThing("电视"));
        bShop.addThing(new SomeThing("冰箱"));
        bShop.addThing(new SomeThing("自行车"));
        
        MyIterator<SomeThing> bIterator = bShop.createIterator();
        while (!bIterator.isDone()) {
            System.out.println(bIterator.next());
        }
        
        
        
    }
}
