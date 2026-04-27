package com.example.y2026.m03.day16;

/**
 * <h1>实现Trie (前缀树)</h1>
 * <p>Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，
 * 用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *  </p>
 *  <a href="https://leetcode.cn/problems/implement-trie-prefix-tree">链接</a>
 */
public class P208 {
}
class Trie {
    Node head;

    class Node {
        Node[] children;
        boolean isEnd;

        public Node(){
            children = new Node[26];
            isEnd = false;
        }

    }

    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        int len = word.length();
        Node cur = head;
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = head;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node cur = head;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

