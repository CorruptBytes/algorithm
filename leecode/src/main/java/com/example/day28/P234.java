package com.example.day28;

import com.leecode.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>回文链表</h1>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 */
public class P234 {
    //先使用数组存储链表节点解决这个问题，今天懒得想别的方法了，好像也想不出别的办法
    //奶奶的效率真低
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (list.get(i) != list.get(size - 1 - i).intValue()) {
                return false;
            }
        }
        return true;
    }
}
