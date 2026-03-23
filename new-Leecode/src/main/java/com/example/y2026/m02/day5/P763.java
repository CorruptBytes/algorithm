package com.example.y2026.m02.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>划分字母区间</h1>
 * <p>给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，
 * 同一字母最多出现在一个片段中。例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，
 * 但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。</p>
 * <a href="https://leetcode.cn/problems/partition-labels/description/">链接</a>
 */
public class P763 {

    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int l = 0,r = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (lastIndex[c - 'a'] > r) {
                r = lastIndex[c - 'a'];
            }
            if (i == r) {
                list.add(r - l + 1);
                l = r + 1;
            }
        }
        return list;
    }
}
