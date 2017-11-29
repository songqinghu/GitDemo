package com.git.books.c_algorithm.leetcode;

public class MergeSortedArray {

    public static void main(String[] args) {

    }

    //三个指针 从后往前(没新数组)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 ==null || nums2 == null){
            return;
        }
        //三个指针
        int len = m + n -1;
        int one = m -1;
        int two = n -1;
        while(one>=0&&two>=0){
            if(nums1[one]>nums2[two]){
                nums1[len] = nums1[one];
                one--;
                len--;
            }else{
                nums1[len] = nums2[two];
                two--;
                len--;
            }
        }
        while(two>=0){
            nums1[len] = nums2[two];
            len--;
            two--;
        }
    }
}
