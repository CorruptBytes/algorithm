package com.example.y2026.m01.day23;


import com.example.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>回文链表</h1>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 */
public class P234 {
    //首先找到链表的中间结点，翻转前半段链表
    //同时遍历前半段链表和后半段链表，判断值是否相等。
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int mid = len / 2 - 1;
        ListNode midNode = head;
        while (mid-- > 0) {
            midNode = midNode.next;
        }
        ListNode[] reverse = reverse(head, midNode);
        head = reverse[0];
        midNode =reverse[1].next;
        if (len % 2 != 0 && midNode != null) {
            midNode = midNode.next;
        }
        while (midNode != null) {
            if (head.val != midNode.val) {
                return false;
            }
            head = head.next;
            midNode = midNode.next;
        }
        return true;
    }

    public ListNode[] reverse(ListNode head,ListNode tail) {
        ListNode prev = tail.next;
        ListNode cur = head;
        while (prev != tail) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return new ListNode[]{tail,head};
    }

    //先使用数组存储链表节点解决这个问题，今天懒得想别的方法了
    //奶奶的效率真低
    public boolean isPalindromeV1(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (list.get(i) != list.get(size - 1 - i).intValue()) {
                return false;
            }
        }
        return true;
    }
}
