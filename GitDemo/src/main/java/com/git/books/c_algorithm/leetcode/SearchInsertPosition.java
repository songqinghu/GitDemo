package com.git.books.c_algorithm.leetcode;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,5,6,7};
        System.out.println(searchInsert(nums, 3));
    }
    //二分查找
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    
}
