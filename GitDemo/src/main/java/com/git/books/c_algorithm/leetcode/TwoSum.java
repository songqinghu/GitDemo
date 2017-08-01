package com.git.books.c_algorithm.leetcode;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//Example:
//
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

public class TwoSum {

    
    public static void main(String[] args) {
        
        int[] nums = new int[]{-3,4,3,90};
        int target = 0;
        
        int[] twoSum = twoSum(nums, target);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }
    
    public static int[] twoSum(int[] nums, int target) {
        
        //get two new array 
        
        for (int i = 0; i < nums.length; i++) {
            
            for (int k = i+1; k < nums.length; k++) {
                if(nums[i] + nums[k] == target){
                    return new int[]{i,k};
                }
            }
        }
        
        
        return null;
    }
}
