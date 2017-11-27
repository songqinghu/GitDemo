package com.git.books.c_algorithm.leetcode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode helper = new ListNode(0);//始终是总表的头部
        ListNode pre = helper;//指针控制向前插入 相对参考系l1
        pre.next = l1;
        
        while(l1!=null && l2!=null){
            
            if(l1.val>l2.val){
                //将l2最前面节点解耦插入链表移动位置指针后
                ListNode next = l2.next;
                l2.next = pre.next;
                pre.next = l2;
                l2 = next;
            }else{
               l1 = l1.next;//移动参考系指针
            }
            pre = pre.next;
        }
        
        if(l2 !=null){
            pre.next = l2;
        }
        
        return helper.next;
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}