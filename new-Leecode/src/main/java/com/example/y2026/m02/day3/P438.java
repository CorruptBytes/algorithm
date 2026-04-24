package com.example.y2026.m02.day3;

import java.util.*;

/**
 * <h1>找到字符串中所有字母异位词</h1>
 * <p>给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">链接</a>
 */
public class P438 {

    public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        if (n1 < n2) return Collections.emptyList();
        int[] windows = new int[26];
        int[] chars = new int[26];
        for (int i = 0; i < n2; i++) {
            chars[p.charAt(i) - 'a']++;
            windows[s.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (Arrays.equals(chars,windows)) res.add(0);
        for (int i = n2; i < n1; i++) {
            windows[s.charAt(i - n2) - 'a']--;
            windows[s.charAt(i) - 'a']++;
            if (Arrays.equals(chars,windows)) res.add(i - n2 + 1);
        }
        return res;
    }



}
