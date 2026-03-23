package com.example.day46;

import com.leecode.structure.ListNode;

/**
 * <h1>旋转链表</h1>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class P61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        ListNode virtualNode  = new ListNode(0,head);
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        k %= length;
        if (k == 0) return head;
        int index = length - k;
        ListNode prev = virtualNode;
        ListNode cur = virtualNode.next;
        while (cur != null && index > 0) {
            cur = cur.next;
            prev = prev.next;
            index--;
        }
        ListNode temp = virtualNode.next;
        prev.next = null;
        virtualNode.next = cur;
        while (cur != null&&cur.next != null) {
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = temp;
        }
        return virtualNode.next;
    }
}
