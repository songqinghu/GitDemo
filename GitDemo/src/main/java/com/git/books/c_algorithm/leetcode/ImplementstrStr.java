package com.git.books.c_algorithm.leetcode;

public class ImplementstrStr {

    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        System.out.println(strStr(a, b));
    }

    
    public static int strStr(String haystack, String needle) {
        
        if(haystack ==null || needle ==null){
            return 0;
        }
        if(haystack.length()<needle.length() ){
            return -1;
        }
        boolean isSuccess = true;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            
            for (int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    isSuccess =false;
                    break;
                }
            }
            if(isSuccess){
                return i;
            }else{
                isSuccess = true;
            }
        }
        return -1;
    }
    
}
