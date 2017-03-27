package com.git.books.b_design_patterns.u_Strategy;
/**
 * @Description: 排序环境
 * @author: songqinghu
 * @date: 2017年3月27日 下午2:52:01
 * Version:1.0
 */
public class SortContext {
    
    private SortStrategy strategy;

    public SortContext(SortStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void sort(int[] array){
        strategy.sort(array);
    }
    
    public SortStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    
}
