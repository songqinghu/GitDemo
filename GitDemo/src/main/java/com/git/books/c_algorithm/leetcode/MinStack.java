package com.git.books.c_algorithm.leetcode;

public class MinStack {

    private int top = 0;
    private int[] stack;
    private int[] minStack;
    private int minTop=-1;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[8];
        minStack = new int[8];
    }
    
    public void push(int x) {
        stack[top] = x;
        
        if(minTop <0 ||minStack[minTop] >=x){
            minTop++;
            minStack[minTop] = x;
        }
        
        if(minTop>=minStack.length-1){
            int[] newStack = new int[top*2];
            for (int i = 0; i < minStack.length; i++) {
                newStack[i] = minStack[i];
            }
            minStack = newStack;
        }
        
        top++;
        if(top >=stack.length){
            int[] newStack = new int[top*2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        
        
        
    }
    
    public void pop() {
        int remove = stack[top-1];
        stack[top-1]=0;
        top--;
        if(remove ==minStack[minTop]){
            minStack[minTop] = 0;
            minTop--;
        }
    }
    
    public int top() {
        return stack[top-1];
    }
    
    public int getMin() {

        return minStack[minTop];
    }
}
