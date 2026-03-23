package com.example.y2026.m01.day19;

import com.leecode.strucutre.ListNode;

/**
 * <h1>求倒数第k个链表节点</h1>
 * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，
 * 请查找并返回倒数第 cnt 个训练项目编号。
 */
public class LCR140 {

    public ListNode trainingPlan(ListNode head, int cnt) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int i = len - cnt;
        while (i-- > 0 && head != null) {
            head = head.next;
        }
        return head;
    }
}
