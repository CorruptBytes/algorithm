package com.example.y2026.m01.day15;

import com.leecode.strucutre.ListNode;

/**
 * <h1>删除链表的倒数第N个结点</h1>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class P19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtualHead = new ListNode(0,head);
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        System.out.println(len);
        int i = len - n;
        ListNode prev = virtualHead;
        while (i-- > 0) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return virtualHead.next;
    }
}
