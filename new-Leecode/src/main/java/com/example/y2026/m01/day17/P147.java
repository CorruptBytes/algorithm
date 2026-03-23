package com.example.y2026.m01.day17;

import com.leecode.strucutre.ListNode;

/**
 * <h1>对链表进行插入排序</h1>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class P147 {
    //迭代
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }

            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return dummy.next;
    }


    //递归,自己写的
    public ListNode insertionSortListV1(ListNode head) {
        if (head == null) return null;
        ListNode virtualHead = new ListNode(Integer.MIN_VALUE,head);
        sortSubList(virtualHead,head.next,head);
        return virtualHead.next;
    }
    public void sortSubList(ListNode root, ListNode cur, ListNode lastSorted) {
        if (cur == null){
            return;
        }
        if (cur.val >= lastSorted.val) {
            sortSubList(root, cur.next, cur);
            return;
        }
        lastSorted.next = cur.next;
        ListNode prev = root;
        while (prev.next.val < cur.val) {
            prev = prev.next;
        }
        cur.next = prev.next;
        prev.next = cur;
        sortSubList(root, lastSorted.next, lastSorted);
    }
    //迭代，与递归思路类似
    public ListNode insertionSortListV2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //lastSorted是最后一个有序结点，lastSorted.next用于指向下一个需要排序的结点
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

}
