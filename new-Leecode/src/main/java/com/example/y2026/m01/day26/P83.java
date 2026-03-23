package com.example.y2026.m01.day26;

import com.leecode.strucutre.ListNode;

/**
 * <h1>删除排序链表中的重复元素</h1>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 */
public class P83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (prev.val == cur.val) {
                cur = cur.next;
                prev.next = cur;
                continue;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplicatesV1(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return head;
    }
}
