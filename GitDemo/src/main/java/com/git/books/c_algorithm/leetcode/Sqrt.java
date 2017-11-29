package com.git.books.c_algorithm.leetcode;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }
    
    //二分法
    public static int mySqrt(int x) {
        
        if(x==0 || x ==1){
            return x;
        }
        
        int left  = 0;
        int right = x;
        
        while(left<=right){
            
            int mid = (left + right)/2;
            
            if(x/mid==mid && x%mid==0){
                return mid;
            }
            
            if(x/mid<mid){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

}
