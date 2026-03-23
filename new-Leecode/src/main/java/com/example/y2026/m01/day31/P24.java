package com.example.y2026.m01.day31;

import com.leecode.strucutre.ListNode;

/**
 * <h1>两两交换链表中的节点</h1>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class P24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev.next.next = cur;
            prev = prev.next.next;
            cur = prev.next;
        }
        return dummy.next;
    }
}
