package com.example.y2026.m02.day2;

import com.example.structure.ListNode;

/**
 * <h1>旋转链表</h1>
 * <p>给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。</p>
 * <a href="https://leetcode.cn/problems/rotate-list/description/">链接</a>
 */
public class P61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0,head);
        //获得链表长度
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        //对k取余
        k = k % len;
        if (k == 0) return head;
        //找到链表的倒数第K个节点
        int index = len - k - 1;
        cur = head;
        //先找到倒数第K + 1个节点
        while (index-- > 0) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = dummy.next;
        dummy.next = head;
        return dummy.next;
    }
}
