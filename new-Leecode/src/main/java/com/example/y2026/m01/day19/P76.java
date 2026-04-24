package com.example.y2026.m01.day19;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>最小覆盖子串</h1>
 * <p>给你一个字符串 s 、一个字符串 t 。
 * 返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""</p>
 * <a href="https://leetcode.cn/problems/minimum-window-substring">链接</a>
 */
public class P76 {
    //todo 时间复杂度有点高，需要考虑优化，目前没有思路
    public String minWindow(String s, String t) {
        int m = s.length();
        int n =t.length();
        if (n > m) return "";
        Map<Character,Integer> chars = new HashMap<>(52);
        Map<Character,Integer> windows = new HashMap<>(52);
        //初始化窗口
        for (int i = 0; i < n; i++) {
            chars.put(t.charAt(i),chars.getOrDefault(t.charAt(i),0) + 1);
            windows.put(s.charAt(i),windows.getOrDefault(s.charAt(i),0) + 1);
        }
        int start = -1;
        int min = Integer.MAX_VALUE;
        int l = 0,r = n;
        if (check(chars,windows)) {
            min = r - l;
            start = l;
        }
        while (r < m) {
            windows.put(s.charAt(r),windows.getOrDefault(s.charAt(r),0) + 1);
            r++;
            while (l < r && check(chars,windows)) {
                if (min > r - l) {
                    min = r - l;
                    start = l;
                }
                windows.put(s.charAt(l),windows.get(s.charAt(l)) - 1);
                l++;
            }
        }
        return min != Integer.MAX_VALUE ? s.substring(start,start + min) : "";
    }

    public boolean check(Map<Character,Integer> chars, Map<Character,Integer> windows) {
        for (Character c : chars.keySet()) {
            if (chars.get(c) > (windows.getOrDefault(c,0))) return false;
        }
        return true;
    }



































}
