package com.example.y2026.m04.day22;


import com.example.structure.ListNode;

/**
 * <h1>排序链表</h1>
 * <p>给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。</p>
 * <a href="https://leetcode.cn/problems/sort-list">链接</a>
 * <h2>进阶:可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？</h2>
 */
public class P148 {
    //插入排序，时间复杂度O(n^2)，空间复杂度O(1)。
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode tail = head;
        ListNode target = tail.next;
        while (target != null) {
            //如果目标节点的值大于尾节点，不需要再遍历，该节点就是新的尾节点
            if (target.val >= tail.val) {
                tail = tail.next;
                target = tail.next;
                continue;
            }
            //辅助遍历排序的节点
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            //先摘出目标排序节点
            tail.next = target.next;
            //遍历寻找插入位置
            while (cur != tail) {
                if (target.val <= cur.val) {
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
            //插入节点
            ListNode temp = pre.next;
            pre.next = target;
            target.next = temp;
            //更新target
            target = tail.next;
        }
        return dummy.next;
    }
}
