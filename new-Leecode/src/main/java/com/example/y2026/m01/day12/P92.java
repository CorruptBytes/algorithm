package com.example.y2026.m01.day12;
/**
 * <h1> 反转链表Ⅱ</h1>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */

import com.leecode.strucutre.ListNode;


public class P92 {

    //一次扫描反转
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode virtualHead = new ListNode(0,head);
        ListNode cur = virtualHead;
        right -= left; //right为需要翻转的次数
        //找到被反转结点的前一个结点
        while (left-- > 0) {
            head = cur;
            cur = cur.next;
        }
        ListNode prev = cur;
        cur = cur.next;
        while (right-- > 0) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        //将翻转后的链表连接回去
        head.next.next = cur;
        head.next = prev;
        return virtualHead.next;
    }

    //二次扫描反转
    public ListNode reverseBetweenV1(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode virtual = new ListNode(0,head);
        ListNode leftNode = null;
        ListNode rightNode = null;
        int len = 0;
        ListNode prev = null;
        head = virtual;
        while (len < right) {
            if (len == left - 1) {
                prev = head;
                leftNode = head.next;
            }
            len++;
            head = head.next;
            if (len == right) {
                rightNode = head;
            }

        }
        ListNode[] reverse = reverse(leftNode, rightNode);
        prev.next = reverse[0];
        return virtual.next;
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
