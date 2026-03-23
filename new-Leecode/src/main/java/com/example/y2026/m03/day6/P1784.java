package com.example.y2026.m03.day6;

/**
 * <h1>检查二进制字符串字段</h1>
 * <p>给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true。否则，返回 false。</p>
 * <a href="https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description">链接</a>
 */
public class P1784 {

    public boolean checkOnesSegment(String s) {
        int len = s.length();
        int i = 0;
        //去除最前面的1
        while (i < len) {
            if (s.charAt(i) == '1') i++;
            else break;
        }
        while (i < len) {
            if (s.charAt(i) == '1') return false;
            i++;
        }
        return true;
    }
}
