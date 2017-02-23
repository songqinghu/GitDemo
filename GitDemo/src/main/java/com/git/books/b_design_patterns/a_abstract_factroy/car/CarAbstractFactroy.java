package com.git.books.b_design_patterns.a_abstract_factroy.car;

/**
 * 
 * @Description: 主抽象工厂类   用来定义一系列产品为最小单元的工厂类
 * 如:生产一辆车,那么车的公共产品可以抽取出来 轮胎,发动机,车窗 等 而车有很多种,那么导致抽象工厂的实现类也有多种,每种生成一种车的组成产品
 * 回过头来看看<<设计模式>>中定义:提供一个创建一系列相关或相互依赖对象的接口,而无需指定它们具体的类.
 * @author: songqinghu
 * @date: 2017年2月21日 下午8:38:08
 * Version:1.0
 */
public interface  CarAbstractFactroy {

    /**
     * @描述：制造发动机
     * @return CarEngine
     * @createTime：2017年2月22日
     * @author: songqinghu
     */
    public abstract CarEngine createCarEngine();
    
    
    /**
     * @描述：制造车轮胎
     * @return CarTyre
     * @createTime：2017年2月22日
     * @author: songqinghu
     */
    public abstract CarTyre createCarTyre();
    
    
}
