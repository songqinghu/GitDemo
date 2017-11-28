package com.git.books.c_algorithm.leetcode;

public class PlusOne {

    public static void main(String[] args) {

    }

    public static int[] plusOne(int[] digits) {
        if(digits==null || digits.length<1){
            return digits;
        }
        int plus = 1;
        for (int i = digits.length-1; i >=0; i--) {
            int current = (digits[i] + plus) % 10;//当前位置
            plus = (digits[i] + plus) /10;//下一位
            
            digits[i] = current;
            
            if(plus == 0){//没有下一位
                return digits;
            }
        }
        //越位
        int[] bigOne = new int[digits.length+1];
        bigOne[0] = 1;
        return bigOne;
    }
}
