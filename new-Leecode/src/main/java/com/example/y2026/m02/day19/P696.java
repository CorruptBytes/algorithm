package com.example.y2026.m02.day19;

/**
 * <h1>计数二进制串</h1>
 * <p>给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，
 * 并且这些子字符串中的所有 0 和所有 1 都是成组连续的。</p>
 * <a href="https://leetcode.cn/problems/count-binary-substrings">链接</a>
 */
public class P696 {

    public int countBinarySubstrings(String s) {
        int res = 0;
        int n = s.length();
        int i = 0;
        int j = 0;
        int count = 0;
        char pre = s.charAt(j);
        while (j < n && s.charAt(j) == pre) {
            count++;
            j++;
        }
        while (j < n) {
            int count1 = 0;
            pre = s.charAt(j);
            while (j < n && s.charAt(j) == pre) {
                count1++;
                j++;
            }
            res += Math.min(count1,count);
            count = count1;
        }
        return res;
    }
}
