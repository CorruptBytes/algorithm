package com.example.day3;

import com.leecode.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class P25 {
    //方法一:将链表存入数组中，将数组k个一组翻转然后连接起来
    public ListNode reverseKGroupV1(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int count = list.size() / k;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < k / 2;j++) {
                int index = i * k + j;
                ListNode temp = list.get(index);
                list.set(j + i * k,list.get(index + k -1));
                list.set(index + k -1,temp);
            }
        }
        ListNode pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            pre.next = list.get(i);
            pre = list.get(i);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }

    //方法一:只要获得k个子节点组成的子链表的头与尾节点就可以翻转子链表
    public ListNode reverseKGroupV2(ListNode head, int k) {
        ListNode virtualHead = new ListNode(0,head);
        ListNode prevNode = virtualHead;
        while (head != null) {
            int len = 0;
            ListNode tail = prevNode;
            while (len < k && tail != null) {
                len++;
                tail = tail.next;
            }
            if (tail == null) return virtualHead.next;
            ListNode[] reverse = reverse(head,tail);
            prevNode.next = reverse[0];
            prevNode = reverse[1];
            head = prevNode.next;
        }

        return virtualHead.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;   // 关键：反转后的尾巴要指向这里
        ListNode cur = head;
        while (prev != tail) {       // 只反转到 tail
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // tail 成为新的头，head 成为新的尾
        return new ListNode[]{tail, head};
    }


}


























