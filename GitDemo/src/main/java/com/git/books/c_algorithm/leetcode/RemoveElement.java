package com.git.books.c_algorithm.leetcode;

public class RemoveElement {

    public static void main(String[] args) {

        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
        
    }

    public static int removeElement(int[] nums, int val) {
        
        if(nums ==null || nums.length<1){
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
