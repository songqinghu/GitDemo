package com.git.books.c_algorithm.leetcode;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(1^1^2^1);
    }

    //位运算 亦或
    public int singleNumber(int[] nums) {
        
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }
}
