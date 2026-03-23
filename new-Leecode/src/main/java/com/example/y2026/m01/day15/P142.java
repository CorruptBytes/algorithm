package com.example.y2026.m01.day15;

import com.leecode.strucutre.ListNode;

import java.util.HashSet;

/**
 * <h1>环形链表Ⅱ</h1>
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class P142 {
    //先用笨方法
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
    //快慢指针方法

    /**
     * 一开始令快指针 fast 和慢指针 slow 都位于头部，然后快指针每次走 2 步，慢指针每次走 1 步，因此快指针走的步数始终等于快指针的 2 倍。
     * 假设从头到环入口的距离为 a，环长度为 b，相遇的时候 a 在环内走了 c，b 比 a 多走了 n 环（n 为正整数），那么有
     * a 走的距离：a + c
     * b 走的距离：a + c + nb
     * 距离关系：2(a + c) = a + c + nb
     * 可以得到： a + c = nb，也就是说，慢指针再往前走 a，在环内走的总距离就是 nb 即整数圈，慢指针就回到了环入口
     * 而 a 是从头到环入口的距离为 a，所以我们再新建一个指针 ptr，ptr 和 slow 每次同时走 1 步，
     * 当 ptr 走了 a 步到环入口的时候，slow 也正好达到环入口，而由于速度一样，它们只有可能在环入口相遇，所以相遇的位置就是环入口位置
     * @param head
     * @return
     */
    public ListNode detectCycleV1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
                return slow;
            }
        }
        return null;
    }
}
