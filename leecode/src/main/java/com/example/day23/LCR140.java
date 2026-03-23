package com.example.day23;

import com.leecode.structure.ListNode;

import java.util.zip.CRC32;

/**
 * <h1>求倒数第k个链表节点</h1>
 * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，
 * 请查找并返回倒数第 cnt 个训练项目编号。
 */
public class LCR140 {
    public ListNode trainingPlan(ListNode head, int cnt) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int index = len - cnt;
        while (index > 0) {
            head = head.next;
            index--;
        }
        return head;
    }
}
