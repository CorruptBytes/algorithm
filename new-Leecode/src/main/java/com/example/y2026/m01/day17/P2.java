package com.example.y2026.m01.day17;

import com.leecode.strucutre.ListNode;

/**
 * <h1>两数相加</h1>
 * 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

public class P2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int newNum = num1 + num2 + flag;
            flag = newNum / 10;
            prev.next = new ListNode(newNum % 10);
            prev = prev.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (flag == 1) {
            prev.next = new ListNode(1);
        }
        return dummy.next;
    }
    //原地相加
    public ListNode addTwoNumbersV1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        int flag = 0;
        ListNode i1 = l1;
        ListNode i2 = l2;
        ListNode prev = l1;
        while (i1 != null && i2 != null) {
            int newNum = i1.val + i2.val + flag;
            flag = newNum / 10;
            i1.val = newNum % 10;
            prev = i1;
            i1 = i1 .next;
            i2 = i2.next;
        }
        ListNode cur = i1 != null ? i1 : i2;
        if (cur != null) {
            prev.next = cur;
            while (cur != null) {
                int newNum = cur.val + flag;
                cur.val = newNum % 10;
                flag = newNum / 10;
                prev = cur;
                cur = cur.next;
            }
        }

        if (flag == 1) {
            prev.next = new ListNode(1);
        }
        return l1;
    }

}
