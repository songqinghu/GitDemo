package com.git.books.b_design_patterns.u_Strategy;
/**
 * @Description: 冒泡排序
 * @author: songqinghu
 * @date: 2017年3月27日 下午2:57:17
 * Version:1.0
 */
public class BubbleSort implements SortStrategy {

    @Override
    public void sort(int[] array) {
        int temp; // 记录临时中间值   
        int size = array.length; // 数组大小   
        for (int i = 0; i < size - 1; i++) {   
            for (int j = i + 1; j < size; j++) {   
                if (array[i] < array[j]) { // 交换两数的位置   
                    temp = array[i];   
                    array[i] = array[j];   
                    array[j] = temp;   
                }   
            }   
        }   
    }

}
