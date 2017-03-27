package com.git.books.b_design_patterns.u_Strategy;
/**
 * @Description: 插入排序
 * @author: songqinghu
 * @date: 2017年3月27日 下午3:01:30
 * Version:1.0
 */
public class InsertSort implements SortStrategy {

    @Override
    public void sort(int[] array) {
        int size = array.length, temp, j;   
        for(int i=1; i<size; i++) {   
            temp = array[i];   
            for(j = i; j > 0 && temp < array[j-1]; j--)   
                array[j] = array[j-1];   
                array[j] = temp;   
        }   
    }

}
