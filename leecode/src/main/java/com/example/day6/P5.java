package com.example.day6;

/**
 * <h1>最长回文子串</h1>
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 */
public class P5 {
    //中心扩散法,由前到后以此选择；每一个字符作为回文字符串的中心，以此为中心向左右扩散
    public String longestPalindrome(String s) {
        int maxLen = 1;
        int maxStart = 0;
        int left,right,len;
        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            len = 1;
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                left--;
                len++;
            }
            while (right <s.length() && s.charAt(i) == s.charAt(right)) {
                right++;
                len++;
            }
            while (left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                len += 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxStart = left + 1;
                maxLen = len;
            }
        }
        return s.substring(maxStart,maxStart + maxLen);
    }

}
