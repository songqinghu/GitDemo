package com.git.books.b_design_patterns.j_facade;
/**
 * @Description: 门面模式测试类
 * @author: songqinghu
 * @date: 2017年3月6日 下午2:51:52
 * Version:1.0
 */
public class FacadeClient {

   public static void main(String[] args) {
    
       HomeFacade facade = new HomeFacade();
       
       facade.leaveHome();
       System.out.println("=======================");
       facade.goHome();
       
   }
    
}
