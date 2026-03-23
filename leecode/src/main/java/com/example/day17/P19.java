package com.example.day17;

import com.leecode.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>删除链表的倒数第N个结点</h1>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class P19 {
    //使用ArrayList保存链表结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        List<ListNode> list = new ArrayList<>(30);
        ListNode virtualNode = new ListNode(0,head);
        list.add(virtualNode);
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode prev = list.get(list.size() - n - 1);
        prev.next = prev.next.next;
        return virtualNode.next;
    }
}
