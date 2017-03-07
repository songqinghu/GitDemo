package com.git.books.b_design_patterns.k_flyweight.b;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @Description: 简单享元模式  只有内部属性,无外部属性
 * @author: songqinghu
 * @date: 2017年3月7日 下午5:19:46
 * Version:1.0
 */
public class FlyWeightFactory {

       //统计所有的享元咖啡 
      private Map<CoffeeEnum, Coffee> coffees  = new HashMap<>();
    
      private int coffeeFlyWeightNum = 0;//享元个数
      
      private static class OnlyFlyWeightFactoryInner{
          private static FlyWeightFactory factory = new FlyWeightFactory();
      }
    
         private  FlyWeightFactory() {
         }
     //匿名内部类方式实现单例工厂模式
     public static FlyWeightFactory getInstance(){
         return OnlyFlyWeightFactoryInner.factory;
     }
     
     //组合模式 树干节点
     public CoffeeTree createCoffees(List<CoffeeEnum> coffeeEnums,List<Table> tables){
        
         CoffeeTree coffeeTree = new CoffeeTree();
         int i = 0;
         for (CoffeeEnum coffeeEnum : coffeeEnums) {
             if(coffees.containsKey(coffeeEnum)){
                 coffeeTree.addCoffee(coffees.get(coffeeEnum));
             }else{
                 CupCoffee coffee = new CupCoffee(coffeeEnum);
                 coffeeTree.addCoffee(coffee);
                 coffees.put(coffeeEnum, coffee);
                 coffeeFlyWeightNum++;
             }
             coffeeTree.addTable(tables.get(i));
             i++;
         }
         return coffeeTree;
     }
     
     //组合模式叶子节点
     public Coffee createCoffee(CoffeeEnum coffeeEnum){
         
             if(coffees.containsKey(coffeeEnum)){
                 return coffees.get(coffeeEnum);
             }else{
                 CupCoffee coffee = new CupCoffee(coffeeEnum);
                 coffees.put(coffeeEnum, coffee);
                 coffeeFlyWeightNum++;
                 return coffee;
             }
     }
     
     
     public int getCoffeeBrandNum(){
         return coffeeFlyWeightNum;
     }
     
    
}
