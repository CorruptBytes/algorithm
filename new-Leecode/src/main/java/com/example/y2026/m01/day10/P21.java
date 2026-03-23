package com.example.y2026.m01.day10;

import com.leecode.strucutre.ListNode;

/**
 * <h1>合并两个有序链表</h1>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class P21 {
    public ListNode mergeTwoListsV1(ListNode list1, ListNode list2) {
        ListNode virtualHead = new ListNode(0,null);
        ListNode prev = virtualHead;
        while (list1 != null || list2 != null) {
            ListNode next = null;
            if (list1 == null) {
                next = list2;
                list2 = list2.next;
            } else {
                next = list1;
                list1 = list1.next;
            }
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    next = list1;
                    list1 = list1.next;
                } else {
                    next = list2;
                    list2 = list2.next;
                }
                prev.next = next;
                prev = prev.next;
                continue;
            }

            prev.next = next;
            prev = prev.next;
        }
        return virtualHead.next;
    }
    public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}
