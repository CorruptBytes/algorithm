package com.example.y2026.m01.day13;

import com.leecode.strucutre.ListNode;

import java.util.HashSet;

/**
 * <h1>相交链表</h1>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class P160 {

    //遍历两个链表，将节点存进哈希表，如果添加失败，则说明添加了相交的节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null || headB != null) {
         if (headA != null) {
             if (!set.add(headA)) {
                 return headA;
             }
             headA = headA.next;
         }
         if (headB != null) {
             if (!set.add(headB)) {
                 return headB;
             }
             headB = headB.next;
         }
        }
        return null;
    }
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
           A = A != null ? A.next : headB;
           B = B != null ? B.next : headA;
        }
        return A;
    }

}