package com.example.day44;

import com.leecode.structure.ListNode;

/**
 * <h1>两两交换链表中的节点</h1>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class P24 {

    public ListNode swapPairs(ListNode head) {
        ListNode virtualNode = new ListNode(0,head);
        ListNode current = head;
        ListNode prev = virtualNode;
        while (current != null && current.next != null) {
            ListNode temp = current.next.next;
            prev.next = current.next;
            prev.next.next = current;
            current.next = temp;
            prev = current;
            current = temp;
        }
        return virtualNode.next;
    }
    /**
     * 给你单链表的头指针 `head` 和两个整数 `left` 和 `right` ，其中 `left <= right` 。
     * 请你前后相邻的元素两两翻转，从位置 `left` 到位置 `right` 的链表节点，
     * 如果最后一个元素没有成对元素，则不翻转此元素，返回 **反转后的链表** 。下标从1开始数。
     */
    public ListNode swapPairs(ListNode head,int left,int right) {
        ListNode virtualNode = new ListNode(0,head);
        ListNode current = head;
        ListNode prev = virtualNode;
        int count = right - left + 1;
        while (--left > 0 && head != null) {
            prev = current;
            current = current.next;
        }
        while (current != null && current.next != null) {
            if (count <=1) break;
            ListNode temp = current.next.next;
            prev.next = current.next;
            prev.next.next = current;
            current.next = temp;
            prev = current;
            current = temp;
            count -= 2;

        }
        return virtualNode.next;
    }

    public static void main(String[] args) {

    }

}
