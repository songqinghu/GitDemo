package com.git.books.b_design_patterns.f_adapter.c;
/**
 * 
 * @Description: 忠犬八公
 * @author: songqinghu
 * @date: 2017年3月1日 下午3:39:18
 * Version:1.0
 */
public class EightDog extends DefaultDogAdapter {

    
    @Override
    public void call() {
        System.out.println("the eight dog call !");
    }
    
    public void waitingMaster(){
        System.out.println("the eight dog waiting master in train station !");
    }
    
    
}
