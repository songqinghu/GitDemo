package com.git.books.c_algorithm.leetcode;

public class RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(3);
        RemoveDuplicatesfromSortedList r = new RemoveDuplicatesfromSortedList();
        ListNode result = r.deleteDuplicates(root);
        while(result!=null){
            System.out.print(result.val +" ");
            result = result.next;
        }
    }
    //链表指针控制 双指针
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null){
            return head;
        }
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        pre.next = head;
        
        while(head.next!=null){
            
            ListNode next = head.next;
            if(head.val != next.val){
                pre.next.next = next;
                pre = pre.next;
            }
            head = next;
        }
        
        if(pre.next.next!=null){
            pre.next.next=null;;
        }
        
        return helper.next;
    }
}
