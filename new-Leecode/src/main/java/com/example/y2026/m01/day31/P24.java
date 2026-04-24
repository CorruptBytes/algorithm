package com.example.y2026.m01.day31;


import com.example.structure.ListNode;

/**
 * <h1>两两交换链表中的节点</h1>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class P24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            //保存下一个需要交换的节点
            ListNode temp = cur.next.next;
            //两两交换
            pre.next = cur.next;
            pre.next.next = cur;
            cur.next = temp;
            //更新节点
            pre = cur;
            cur = temp;
        }
        return dummy.next;
    }
}
