package com.example.y2026.m01.day10;

/**
 * <h1>最长回文子串</h1>
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 */
public class P5 {
    //以每一个字符作为中心，寻找以此字符为中心的最长回文子串
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0;
        int end = 0;
        int max = end - start + 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && s.charAt(left) == c) {
                left--;
            }
            while (right < s.length() && s.charAt(right) == c) {
                right++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1 > max) {
                max = right - left - 1;
                start = left + 1;
                end = right - 1;
            }
        }
        return s.substring(start,end + 1);
    }
}
