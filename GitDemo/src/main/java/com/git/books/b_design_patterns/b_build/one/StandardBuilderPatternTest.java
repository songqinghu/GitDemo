package com.git.books.b_design_patterns.b_build.one;
/**
 * 
 * @Description: 标准建造者模式测试类
 * @author: songqinghu
 * @date: 2017年2月23日 下午2:53:23
 * Version:1.0
 */
public class StandardBuilderPatternTest {

    
    public static void main(String[] args) {
        
          //生产一个宝马车
          CarBuilder builder = new BMWCarBuilder();
        
          CarDirector director = new CarDirector(builder);
          
          
          Car car = director.build();
          
          car.run();//宝马车启动
          
          //生产一个奔驰车 
          
          builder = new AWGCarBuilder();
          
          director = new CarDirector(builder);
          
          car = director.build();
          
          car.run();
        
    }
    
    
    
    
    
}
