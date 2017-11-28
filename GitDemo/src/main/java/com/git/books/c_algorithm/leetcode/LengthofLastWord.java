package com.git.books.c_algorithm.leetcode;

public class LengthofLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("  "));
    }
    //基本编码
    public static int lengthOfLastWord(String s) {
        
        if(s ==null || s.length()<1){
            return 0;
        }
        int index1 = s.length()-1;
        while(index1>=0 && s.charAt(index1)==' '){
            index1--;//到非空格位置终止
        }
        int index2 = index1;
        while(index2>=0 && s.charAt(index2)!=' '){
            index2--;//到空格位置终止
        }
        return index1 -index2;
    }

}
