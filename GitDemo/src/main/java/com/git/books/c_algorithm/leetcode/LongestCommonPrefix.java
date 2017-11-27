package com.git.books.c_algorithm.leetcode;

import org.codehaus.stax2.ri.typed.StringBase64Decoder;
import org.springframework.core.env.SystemEnvironmentPropertySource;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        
        System.out.println(longestCommonPrefix(new String[]{"a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        
        if(strs ==null || strs.length==0 || strs[0].trim().length()<1 ){
            return "";
        }
        
        int index = 0;
        StringBuffer sTemp = new StringBuffer();
        while(index <= strs[0].length()-1){
            for (int i = 0; i < strs.length; i++) {
                if(index > strs[i].length()-1 ||  strs[i].charAt(index) != strs[0].charAt(index)){
                    return sTemp.toString();
                }
            }
            sTemp.append(strs[0].charAt(index));
            index++;
        }
        return sTemp.toString();
    }
}
