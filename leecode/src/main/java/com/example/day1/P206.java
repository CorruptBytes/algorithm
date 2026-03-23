package com.example.day1;

import com.leecode.structure.ListNode;


public class P206 {
    //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next =  temp;
        }
        head.next = null;
        return prev;
    }
}
