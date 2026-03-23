package com.example.y2026.m02.day14;

import com.leecode.strucutre.ListNode;

/**
 * <h1>分割链表</h1>
 * <p>给你一个链表的头节点 head 和一个特定值 x ，
 * 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。</p>
 * <a href="https://leetcode.cn/problems/partition-list">链接</a>
 */
public class P86 {

    public ListNode partition(ListNode head, int x) {
        ListNode preHead = null;
        ListNode afterHead = null;
        ListNode pre = null;
        ListNode aft = null;
        while (head != null) {
            if (head.val < x) {
                if (pre == null) {
                    pre = head;
                    preHead = pre;
                }
                else {
                    pre.next = head;
                    pre = pre.next;
                }
            } else {
                if (aft == null) {
                    aft = head;
                    afterHead = aft;
                }
                else {
                    aft.next = head;
                    aft = aft.next;
                }
            }
            head = head.next;
        }
        if (preHead != null && afterHead != null) {
            pre.next = afterHead;
            aft.next = null;
            return preHead;
        } else if (preHead != null) {
            pre.next = null;
            return preHead;
        } else if (afterHead != null){
            aft.next = null;
            return afterHead;
        } else {
            return null;
        }
    }
}
