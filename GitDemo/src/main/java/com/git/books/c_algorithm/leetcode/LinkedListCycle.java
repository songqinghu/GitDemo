package com.git.books.c_algorithm.leetcode;

public class LinkedListCycle {

    public static void main(String[] args) {

    }

    //两个速度指针
    public boolean hasCycle(ListNode head) {
        
       if(head ==null){
           return false;
       }
       ListNode walker = head;
       ListNode runner = head;
       while(runner!=null && runner.next!=null){
           
           walker = walker.next;
           runner = runner.next.next;
           if(walker == runner){
               return true;
           }
       }
       return false;
    }
}
