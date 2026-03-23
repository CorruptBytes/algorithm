package com.example.day16;

import com.leecode.structure.ListNode;

public class P82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode virtualNode = new ListNode(0,head);
        int deleteValue = Integer.MIN_VALUE;
        ListNode current = head;
        ListNode prev = virtualNode;
        while (current != null) {
            if (current.val == deleteValue) {
                prev.next = prev.next.next;
                current = current.next;
                continue;
            }
            if (current.next != null && current.val == current.next.val) {
                deleteValue = current.val;
                continue;
            }
            prev = current;
            current = current.next;
        }
        return virtualNode.next;
    }
}
