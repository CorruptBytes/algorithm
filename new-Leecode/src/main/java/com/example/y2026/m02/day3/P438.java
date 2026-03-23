package com.example.y2026.m02.day3;

import java.util.*;

/**
 *
 * <h1>找到字符串中所有字母异位词</h1>
 * <p>给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">链接</a>
 */
public class P438 {

    public List<Integer> findAnagrams(String s, String p) {
        int len1 = p.length();
        int len2 = s.length();
        if (len2 < len1 || len2 == 0) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        int[] counts = new int[26];
        int[] windows = new int[26];
        for (int i = 0; i < len1; i++) {
            counts[p.charAt(i) - 97]++;
            windows[s.charAt(i) - 97]++;
        }
        if (Arrays.equals(counts, windows)) list.add(0);
        for (int i = 0; i < len2 - len1; i++) {
            windows[s.charAt(i) - 97]--;
            windows[s.charAt(i + len1) - 97]++;
            if (Arrays.equals(counts, windows)) list.add(i + 1);
        }
        return list;
    }
}
