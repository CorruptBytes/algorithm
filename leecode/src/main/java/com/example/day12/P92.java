package com.example.day12;

import com.leecode.structure.ListNode;

import java.util.logging.Level;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class P92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode virtual = new ListNode(0,head);
        ListNode leftNode = null;
        ListNode rightNode = null;
        int size = 0;
        ListNode prev = null;
        head = virtual;
        while (size <= right) {
            if (size == left - 1) {
                prev = head;
                leftNode = head.next;
            }
            if (size == right) {
                rightNode = head;
            }
            size++;
            head = head.next;
        }
        ListNode[] reverse = reverse(leftNode, rightNode);
        prev.next = reverse[0];
        return virtual.next;
    }
    public ListNode[] reverse(ListNode head,ListNode tail) {
        ListNode next = tail.next;
        ListNode curr = head;
        while (next != tail) {
            ListNode temp = curr.next;
            curr.next = next;
            next = curr;
            curr = temp;
        }
        return new ListNode[]{tail,head};
    }

}
