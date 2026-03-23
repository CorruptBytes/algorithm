package com.example.y2026.m01.day12;

import com.leecode.strucutre.ListNode;

import java.util.HashSet;

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
    //龟兔赛跑，通过快慢指针遍历，如果有环，快慢指针最终一定会相遇。
    public boolean hasCycleV1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
