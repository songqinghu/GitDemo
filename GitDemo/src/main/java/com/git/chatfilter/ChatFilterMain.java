package com.git.chatfilter;

public class ChatFilterMain {

    public static void main(String[] args) {
        
        String test = "气垫保护内层、提供更佳保护，外层书写容易，标签可黏贴性强";
        
        char[] chars = test.toCharArray();
        
        for (char c : chars) {
            System.out.println("数值:"+(int)c+" 实际:"+c);
        }
        
    }
}
