package com.example.day12;

import com.leecode.structure.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 */
public class P141 {

    //通过HashSet判断链表是否成环
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    //龟兔赛跑，通过快慢指针，如果成环，快慢指针必定会相遇
    public boolean hasCycleV2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
        }
        return false;
    }
}
