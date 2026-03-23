package com.example.day4;

import com.leecode.structure.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class P21 {
    //第一个版本，感觉while循环还可以继续优化
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode virtualHead = new ListNode(0);
        ListNode newList = virtualHead;
        while (curr1 != null || curr2 != null) {
            if (curr1 == null) {
                newList.next = curr2;
                return virtualHead.next;
            }
            if (curr2 == null) {
                newList.next = curr1;
                return virtualHead.next;
            }
            if (curr1.val > curr2.val) {
                newList.next = curr2;
                newList = newList.next;
                curr2 = curr2.next;
            } else {
                newList.next = curr1;
                newList = newList.next;
                curr1 = curr1.next;
            }
        }
        return virtualHead.next;
    }
}

