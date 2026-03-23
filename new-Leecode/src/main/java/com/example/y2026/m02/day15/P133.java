package com.example.y2026.m02.day15;

import java.util.*;

/**
 * <h1>克隆图</h1>
 * <p>给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *  </p>
 *  <a href="https://leetcode.cn/problems/clone-graph">链接</a>
 */
public class P133 {
    HashMap<Node,Node> map = new HashMap<>();
    HashSet<Node> set = new HashSet<>();
    public Node cloneGraph(Node node) {
        digui(node);
        return map.get(node);
    }
    public void digui(Node node) {
        if (node == null) return;
        if (!set.add(node)) {
            return;
        }
        Node newNode = map.computeIfAbsent(node, n -> new Node(n.val));
        for (Node neighbor : node.neighbors) {
            Node newNeighbor = map.computeIfAbsent(neighbor, n -> new Node(n.val));
            newNode.neighbors.add(newNeighbor);
            digui(neighbor);
        }
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
