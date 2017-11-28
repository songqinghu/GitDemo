package com.git.books.c_algorithm.leetcode;

public class MaximumSubarray {

    public static void main(String[] args) {
        
        int[] nums = new int[]{1,2,-1,4,-1};
        System.out.println(maxSubArray(nums));
    }
    
    //动态规划
    public static int maxSubArray(int[] nums) {
        if(nums==null || nums.length<1){
            return 0;
        }
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
             local = Math.max(nums[i], local + nums[i]);//局部最优解
             global = Math.max(local, global);//全局最优解
        }
        return global;
    }
}
