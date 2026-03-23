package com.example.day35;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <h1>单词拆分</h1>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class P139 {

    //无法解决如s ="aaaaaaa",wordDict =["aaaa","aaa"]的问题
//    public boolean wordBreak(String s, List<String> wordDict) {
//        HashSet<String> words = new HashSet<>(wordDict);
//        int left = 0;
//        int right;
//        for (right = 0; right < s.length(); right++) {
//            if (words.contains(s.substring(left,right + 1))) {
//                left = right + 1;
//            }
//        }
//        return left == right;
//    }
    //动态规划
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        int minSize = Integer.MAX_VALUE;
        for (String string : wordDict) {
            minSize = Math.min(string.length(),minSize);
        }
        dp[0] = true;
        for (int i = minSize; i <= s.length(); i++) {
            for (String string : wordDict) {
                int startIndex = i - string.length();
                if (startIndex < 0) {
                    continue;
                }
                String substring = s.substring(startIndex, i);
                if (dp[i - string.length()] && string.equals(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        P139 test = new P139();
        test.wordBreak(s,list);
    }
}
