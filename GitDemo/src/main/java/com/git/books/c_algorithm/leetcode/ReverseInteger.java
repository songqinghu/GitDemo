package com.git.books.c_algorithm.leetcode;

import java.util.ArrayList;

/**
 * 
 * @Description: 反转给定的整数
 * @author: songqinghu
 * @date: 2017年11月27日 下午3:19:49
 * Version:1.0
 */
public class ReverseInteger {

    
    public static void main(String[] args) {
        
        

    }
    
    public int reverse(int x) {
        if(x == Integer.MAX_VALUE){
            return 0;
        }
        int num = Math.abs(x);
        int rev = 0;
        while(num!=0){
            if(rev > (Integer.MAX_VALUE - num % 10)/10){
                return 0;
            }
            rev  = rev*10 + num%10;
            num = num/10;
        }
        return x>0? rev:-rev;
    }
  
    
}
