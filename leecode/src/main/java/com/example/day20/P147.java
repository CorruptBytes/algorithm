package com.example.day20;

import com.leecode.structure.ListNode;

/**
 * <h1>排序链表</h1>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class P147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode virtualHead = new ListNode(Integer.MIN_VALUE,head);
        sortSubList(virtualHead,head,virtualHead);
        return virtualHead.next;
    }
    public void sortSubList(ListNode root,ListNode node,ListNode prev) {
        if (node == null){
            return;
        }
        if (node.val >= prev.val) {
            sortSubList(root,node.next,node);
            return;
        }
        prev.next = node.next;
        ListNode curr = root.next;
        ListNode currPrev = root;
        while (curr != null && curr.val < node.val) {
            currPrev = curr;
            curr = curr.next;
        }
        // 插入 node
        currPrev.next = node;
        node.next = curr;
        sortSubList(root,prev.next,prev);
    }

    public static void main(String[] args) {
        P147 p148 = new P147();
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(100);
        ListNode node1 = p148.insertionSortList(node);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}
