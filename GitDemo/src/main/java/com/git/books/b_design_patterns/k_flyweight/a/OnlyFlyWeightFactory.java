package com.git.books.b_design_patterns.k_flyweight.a;

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
public class OnlyFlyWeightFactory {

       //统计所有的享元咖啡 
      private Map<OnlyCoffeeEnum, OnlyCoffee> coffees  = new HashMap<>();
    
      private int coffeeFlyWeightNum = 0;//享元个数
      
      private static class OnlyFlyWeightFactoryInner{
          private static OnlyFlyWeightFactory factory = new OnlyFlyWeightFactory();
      }
    
         private  OnlyFlyWeightFactory() {
         }
     //匿名内部类方式实现单例工厂模式
     public static OnlyFlyWeightFactory getInstance(){
         return OnlyFlyWeightFactoryInner.factory;
     }
     
     //组合模式 树干节点
     public OnlyCoffeeTree createCoffees(List<OnlyCoffeeEnum> coffeeEnums){
        
         OnlyCoffeeTree coffeeTree = new OnlyCoffeeTree();
         
         for (OnlyCoffeeEnum coffeeEnum : coffeeEnums) {
             if(coffees.containsKey(coffeeEnum)){
                 coffeeTree.addCoffee(coffees.get(coffeeEnum));
             }else{
                 OnlyCupCoffee coffee = new OnlyCupCoffee(coffeeEnum);
                 coffeeTree.addCoffee(coffee);
                 coffees.put(coffeeEnum, coffee);
                 coffeeFlyWeightNum++;
             }
         }
         return coffeeTree;
     }
     
     //组合模式叶子节点
     public OnlyCoffee createCoffee(OnlyCoffeeEnum coffeeEnum){
         
             if(coffees.containsKey(coffeeEnum)){
                 return coffees.get(coffeeEnum);
             }else{
                 OnlyCupCoffee coffee = new OnlyCupCoffee(coffeeEnum);
                 coffees.put(coffeeEnum, coffee);
                 coffeeFlyWeightNum++;
                 return coffee;
             }
     }
     
     
     public int getCoffeeBrandNum(){
         return coffeeFlyWeightNum;
     }
     
    
}
