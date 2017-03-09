package com.git.books.b_design_patterns.m_chain_of_responsibility;
/**
 * @Description: 鼓声
 * @author: songqinghu
 * @date: 2017年3月9日 下午3:19:21
 * Version:1.0
 */
public class Drums {
    
     private static class DrumsInner{
         private static final Drums drums = new Drums();
     }
    
     private Object lock = new Object();
     
     private Drums() {
     }
     
     public static Drums getInstance(){
         return DrumsInner.drums;
     }
     
     
     private boolean isNoise = true;

     
     public boolean getOrSetNoise(String noise){
         if(noise ==null){
             return isNoise;
         }else{
             this.isNoise = Boolean.parseBoolean(noise);
             return isNoise;
         }
     }

}
