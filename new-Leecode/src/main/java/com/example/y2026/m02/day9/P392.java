package com.example.y2026.m02.day9;

/**
 * <h1>判断子序列</h1>
 * <p>给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？</p>
 * <a href="https://leetcode.cn/problems/is-subsequence/description">链接</a>
 */
public class P392 {

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        int sLen = s.length();
        int tLen = t.length();
        while (sIndex < sLen && tIndex < tLen) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == sLen;
    }
}
