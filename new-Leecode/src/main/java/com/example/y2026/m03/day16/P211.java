package com.example.y2026.m03.day16;

/**
 * <h1>添加与搜索单词-数据结构设计</h1>
 *
 * <p>请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；
 * 否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。</p>
 * <a href="https://leetcode.cn/problems/design-add-and-search-words-data-structure">链接</a>
 */
public class P211 {
}

class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return _search(word,trie.head,0);
    }

    public boolean _search(String word, Trie.Node node,int index) {
        if (node == null) return false;
        if (index >= word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(index);
        boolean res = false;
        if (c == '.') {
            for (Trie.Node child : node.children) {
                if (child != null) {
                     if (!res) {
                         res = _search(word,child,index + 1);
                     }
                }
            }
        } else {
            return  _search(word,node.children[c - 'a'], index + 1);
        }
        return res;
    }
}

