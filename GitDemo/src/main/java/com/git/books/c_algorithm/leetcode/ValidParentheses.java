package com.git.books.c_algorithm.leetcode;

import java.util.LinkedList;

public class ValidParentheses {

    public static void main(String[] args) {

    }
    //(', ')', '{', '}', '[' and '] 使用栈 左为进 右括号为出
    public static boolean isValid(String s) {
        if(s==null || s.length()<1){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            
            switch (s.charAt(i)) {
                case '(':
                case '[':    
                case '{':    
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() !='('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() !='['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() !='{'){
                        return false;
                    }
                    break;
                default:
                    break;
                }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
//if(s==null || s.length()==0)  
//    return true;  
//LinkedList<Character> stack = new LinkedList<Character>();  
//for(int i=0;i<s.length();i++)  
//{  
//    switch(s.charAt(i))  
//    {  
//        case '(':  
//        case '{':  
//        case '[':  
//            stack.push(s.charAt(i));  
//            break;  
//        case ')':  
//            if(stack.isEmpty() || stack.pop()!='(')  
//                return false;  
//            break;  
//        case '}':  
//            if(stack.isEmpty() || stack.pop()!='{')  
//                return false;  
//            break;  
//        case ']':  
//            if(stack.isEmpty() || stack.pop()!='[')  
//                return false;  
//            break;   
//        default:  
//            break;  
//    }  
//}  
//if(stack.isEmpty())  
//    return true;  
//return false;  