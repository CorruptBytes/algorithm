package com.example.y2026.m01.day12;

import com.leecode.strucutre.ListNode;

/**
 * <h1>合并K个升序链表</h1>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class P23 {
    //先采用一个个合并的方式，不过感觉可以借鉴归并排序的思想。
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode virtualNode = new ListNode(0);
        for (int i = 0; i < lists.length; i++) {
            virtualNode.next = mergeTwoLists(virtualNode.next, lists[i]);

        }
        return virtualNode.next;
    }
    //递归两两合并
    public ListNode mergeKListsV1(ListNode[] lists) {
        if (lists.length == 0) return null;
        merge(lists,lists.length);
        return lists[0];
    }
    public void merge(ListNode[] lists,int len) {
        if (len <= 1) return;
        int count = 0;
        for (int i = 0; i < len; i += 2) {
            if (i == len - 1) {
                lists[count++] = lists[len - 1];
                break;
            }
            lists[count++] = mergeTwoLists(lists[i], lists[i + 1]);
        }
        merge(lists,count);
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        ListNode virtualNode = new ListNode(0);
        ListNode prev = virtualNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 != null ? l1 : l2;
        return virtualNode.next;
    }
}
