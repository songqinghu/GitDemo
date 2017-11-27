package com.git.books.c_algorithm.leetcode;
/**
 * @Description: Determine whether an integer is a palindrome. Do this without extra space.
 * @author: songqinghu
 * @date: 2017年11月27日 下午4:21:27
 * Version:1.0
 */
public class PalindromeNumber {

    
    public static void main(String[] args) {
        
        
    }
    
    public static boolean isPalindrome(int x) {
        
        if(x == Integer.MAX_VALUE || x <0){
            return false;
        }
        int rev = 0;
        int num = x;
        while(x!=0){
            if(rev>(Integer.MAX_VALUE - x%10)/10){
                return false;
            }
            rev = rev*10 + x%10;
            x = x/10;
        }
        return rev == num? true:false;
    }
}
