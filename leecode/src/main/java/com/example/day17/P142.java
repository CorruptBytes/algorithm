package com.example.day17;

import com.leecode.structure.ListNode;

import java.util.HashSet;

/**
 * <h1>环形链表Ⅱ</h1>
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class P142 {
    //HashSet
    public ListNode detectCycleV1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    //快慢指针


    public ListNode detectCycleV2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }

    /**
     * 还有一种方法
     * 快慢指针相遇后，然后让慢指针再跑一圈算出圆的长度；然后再定义两个指针，让其中一个从头先走一圈圆的长度，然后再两个指针再一起走，最终他们会在圆的起点相遇
     */
}
