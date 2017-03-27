package com.git.books.b_design_patterns.u_Strategy;
/**
 * @Description: 选择排序
 * @author: songqinghu
 * @date: 2017年3月27日 下午3:00:08
 * Version:1.0
 */
public class SelectSort implements SortStrategy {

    @Override
    public void sort(int[] array) {
        int size = array.length, temp;   
        for (int i = 0; i < size; i++) {   
            int k = i;   
            for (int j = size - 1; j >i; j--)  {   
                if (array[j] < array[k])  k = j;   
            }   
            temp = array[i];   
            array[i] = array[k];   
            array[k] = temp;   
        }   
    }

}
