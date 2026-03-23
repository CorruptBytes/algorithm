package com.example.y2026.m01.day26;

import java.util.List;

/**
 * <h1>单词拆分</h1>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class P139 {
    //动态规划有没有搞头
    public boolean wordBreak(String s, List<String> wordDict) {
        int min = wordDict.getFirst().length();
        for (String string : wordDict) {
            min = Math.min(min,string.length());
        }
        int n = s.length();
        //dp[i + 1]为s[i]前的子串能否匹配,dp[0]表示空串能否匹配,这是一定能匹配的
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = min; i <= n; i++) {
            for (String string : wordDict) {
                int index = i - string.length();
                if (index < 0) {
                    continue;
                }
                String sub = s.substring(index,i);
                if (dp[index] && sub.equals(string)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
