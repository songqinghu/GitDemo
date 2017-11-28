package com.git.books.c_algorithm.leetcode;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1", "111"));
    }
    
    //维护一个进位指针
    public static String addBinary(String a, String b) {
        
        if(a==null || a.length()<1){
            return b;
        }
        
        if(b ==null || b.length()<1){
            return a;
        }
        
        int nextLocal = 0;
        
        int i = a.length()-1;
        int j = b.length()-1;
        
        StringBuffer sb = new StringBuffer();
        
        while(i>=0 && j>=0){//按位置相加到一个加完
            
            //该位置相加
            int result = (int)(a.charAt(i) - '0' + b.charAt(j) - '0') + nextLocal;
            nextLocal = result/2;//进位判断
            int current = result%2;//当前位置结果
            sb.append(current);
            i--;
            j--;
        }
        
        while(i>=0){
            int result = (int)(a.charAt(i) -'0') +nextLocal;
            nextLocal = result/2;//进位判断
            int current = result%2;//当前位置结果
            sb.append(current);
            i--;
        }
        
        while(j>=0){
            int result = (int)(b.charAt(j) -'0') +nextLocal;
            nextLocal = result/2;//进位判断
            int current = result%2;//当前位置结果
            sb.append(current);
            j--;
        }
        //最后的进位判断
        if(nextLocal!=0){
            sb.append(nextLocal);
        }
        
        return sb.reverse().toString();
    }
}
