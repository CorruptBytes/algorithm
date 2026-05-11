package com.example.y2026.m01.day26;

import java.util.List;

/**
 * <h1>单词拆分</h1>
 * <p>给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。</p>
 * <a href="https://leetcode.cn/problems/word-break">链接</a>
 */
public class P139 {
    //动态规划有没有搞头
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if (i - word.length() >= 0 && dp[i - word.length()]) {
                    String sub = s.substring(i - word.length(),i);
                    if (word.equals(sub)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
