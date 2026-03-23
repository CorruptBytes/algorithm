package com.example.day39;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>随机链表的复制</h1>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，
 * 其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
 * 并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 */
public class P138 {
    //通过Map映射Node的关系
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node virtualNode = new Node(0);
        Node prev = virtualNode;
        while (head != null) {
            Node node = map.getOrDefault(head, null);
            if (node == null) {
                node = new Node(head.val);
                map.put(head,node);
            }
            prev.next = node;
            if (head.random != null) {
                Node random = map.getOrDefault(head.random, null);
                if (random == null) {
                    random = new Node(head.random.val);
                    map.put(head.random,random);
                }
                node.random = random;
            }
            head = head.next;
            prev = prev.next;
        }
        return virtualNode.next;
    }

}
 class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
