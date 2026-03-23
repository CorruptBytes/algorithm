package com.example.y2026.m01.day14;

import com.leecode.strucutre.ListNode;

/**
 * <h1>删除排序链表中的重复元素Ⅱ</h1>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class P82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode virtualHead = new ListNode(0,head);
        ListNode prev = virtualHead;
        ListNode cur = head;
        while (cur != null) {
            boolean repeat = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                repeat = true;
            }
            if (repeat) {
                cur = cur.next;
                prev.next = cur;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return virtualHead.next;
    }

    public ListNode deleteDuplicatesV1(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            if (prev.next.val == prev.next.next.val) {
                int val = prev.next.val;
                // 删除所有等于 val 的节点
                while (prev.next != null && prev.next.val == val) {
                    prev.next = prev.next.next;
                }
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

}
