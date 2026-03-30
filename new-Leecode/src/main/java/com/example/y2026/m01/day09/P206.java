package com.example.y2026.m01.day09;

import com.example.structure.ListNode;

/**
 * <h1>反转链表</h1>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class P206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
