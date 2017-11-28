package com.git.books.c_algorithm.leetcode;

public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(removeDuplicates(nums));
    }
    
    public static int removeDuplicates(int[] nums) {
        
        if(nums ==null || nums.length <1){
            return 0;
        }
        int index = 1;//从第二个元素开始才会出现重复
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
    
}
