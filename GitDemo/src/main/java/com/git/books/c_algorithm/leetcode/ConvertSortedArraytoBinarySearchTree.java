package com.git.books.c_algorithm.leetcode;

public class ConvertSortedArraytoBinarySearchTree {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        
        return toBSTHelp(nums, 0, nums.length-1);
    }
    
    
    public TreeNode toBSTHelp(int[] nums,int start,int end){
        
        if(start>end){
            return null;
        }
        
        int mid = (start+end)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = toBSTHelp(nums, start, mid-1);
        root.right= toBSTHelp(nums, mid+1, end);
        
        return root;
    }
}
