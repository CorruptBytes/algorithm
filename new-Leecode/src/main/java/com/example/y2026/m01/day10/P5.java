package com.example.y2026.m01.day10;

/**
 * <h1>最长回文子串</h1>
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 */
public class P5 {
    //以每一个字符作为中心，寻找以此字符为中心的最长回文子串
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        int lMax = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) continue;
            char c = s.charAt(i);
            int l = i;
            int r = i;
            while (l >= 0 && s.charAt(l) == c) {
                l--;
            }
            while (r < n && s.charAt(r) == c) {
                r++;
            }
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            l++;
            r--;
            if (r - l + 1 > max) {
                max = r - l + 1;
                lMax = l;
            }
        }
        return s.substring(lMax,lMax + max);
    }
}
