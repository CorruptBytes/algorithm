package com.example.day13;

import com.leecode.structure.ListNode;

/**
 * <h1>合并K个升序链表</h1>
 * <p>给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *  </p>
 */
public class P23 {
    //每次遍历一遍List，找到最小的节点，将他添加在节点后，移到下一个节点。
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode virtualHead = new ListNode(0);
        ListNode curr = virtualHead;
        while (true) {
            ListNode minNode = null;
            int index = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null) {
                    minNode = lists[i];
                    index = i;
                    continue;
                }
                if (lists[i].val <= minNode.val) {
                    minNode = lists[i];
                    index = i;
                }
            }
            if (minNode == null) {
                break;
            }
            curr.next = minNode;
            curr = curr.next;
            lists[index] = lists[index].next;
        }
        return virtualHead.next;
    }
}
