package com.example.y2026.m04.day18;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>无重复字符的最长子串</h1>
 * <p>给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。</p>
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters">链接</a>
 */
public class P3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i - set.size()));
                i--;
            }
            max = Math.max(max,set.size());
        }
        return max;
    }
}
