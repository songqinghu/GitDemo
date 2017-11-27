package com.git.books.c_algorithm.leetcode;

import java.util.HashMap;

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
        
        int[] twoSum = twoSumForHash(nums, target);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }
    /** the one method */
    public static int[] twoSum(int[] nums, int target) {
        
        //get two new array 
        
        for (int i = 0; i < nums.length; i++) {
            
            for (int k = i+1; k < nums.length; k++) {
                if(nums[i] + nums[k] == target){
                    return new int[]{i,k};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    /** the two method */
    public static int[] twoSumForHash(int[] nums,int target){
        
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
    
}
