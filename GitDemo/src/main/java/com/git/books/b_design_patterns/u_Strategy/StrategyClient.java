package com.git.books.b_design_patterns.u_Strategy;

/**
 * @Description: 策略模式测试类
 * @author: songqinghu
 * @date: 2017年3月27日 下午3:04:34
 * Version:1.0
 */
public class StrategyClient {

    public static void main(String[] args) {
        
        int[] array = {22,1,324,45,6,44,334};
        
        SortContext context = new SortContext(new InsertSort());
        context.sort(array);
        
        printArray(array);
        
        
    }
    
    public static void printArray(int[] array){
        for (int i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
    
    
}
