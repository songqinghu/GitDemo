package com.git.books.c_algorithm.leetcode;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        
        ListNode l3 = addTwoNumbers(l1, l2);
        while (l3.next!=null) {

            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        
        root = new ListNode(l1.val + l2.val);
        
        while(l1.next!=null){
            l1 = l1.next;
            l2 = l2.next;
            root.next = new ListNode(l1.val + l2.val);

        }
        
        return root;
    }
}

class ListNode{
    
    int val;
    ListNode next;
    ListNode(int x) {
        val = x; 
    }
    
}