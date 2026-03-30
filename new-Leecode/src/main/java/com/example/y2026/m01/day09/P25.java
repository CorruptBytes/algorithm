package com.example.y2026.m01.day09;

import com.example.structure.ListNode;

/**
 * <h1>K个一组翻转链表</h1>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class P25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode virtualHead = new ListNode(0,head);
        ListNode prevNode = virtualHead;
        while (head != null) {
            int len = 0;
            ListNode tail = prevNode;
            while (len++ < k && tail != null) {
                tail = tail.next;
            }
            if (tail == null) return virtualHead.next;
            ListNode[] reverse = reverse(head,tail);
            prevNode.next = reverse[0];
            prevNode = reverse[1];
            head = prevNode.next;
        }

        return virtualHead.next;
    }

    public ListNode[] reverse(ListNode head,ListNode tail) {
        ListNode prev = tail.next; //指向上一个已经完成翻转的结点
        ListNode cur = head; //指向正在处理的结点

        while (prev != tail) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return new ListNode[]{tail,head};
    }
}
