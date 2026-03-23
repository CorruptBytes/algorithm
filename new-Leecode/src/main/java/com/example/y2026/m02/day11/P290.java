package com.example.y2026.m02.day11;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>单词规律</h1>
 * <p>给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如，
 * pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。具体来说：
 * pattern 中的每个字母都 恰好 映射到 s 中的一个唯一单词。
 * s 中的每个唯一单词都 恰好 映射到 pattern 中的一个字母。
 * 没有两个字母映射到同一个单词，也没有两个单词映射到同一个字母。</p>
 * <a href="https://leetcode.cn/problems/word-pattern">链接</a>
 */
public class P290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> map1 = new HashMap<>();
        int n1 = pattern.length();
        int n2 = s.length();
        int i1 = 0;
        int i2 = 0;
        while (i1 < n1 && i2 < n2) {
            char c = pattern.charAt(i1);
            String string = map.get(c);
            if (string == null) {
                int start = i2;
                while (i2 < n2 && s.charAt(i2) != ' ') {
                    i2++;
                }
                String substring = s.substring(start, i2);
                map.put(c,substring);
                if (!map1.containsKey(substring)) {
                    map1.put(substring,c);
                } else {
                    return false;
                }
            } else {
                int len = string.length();
                if (i2 + len > n2) return false;
                String substring = s.substring(i2, i2 + len);
                if (!substring.equals(string)) return false;
                i2 += len;
            }
            i2++;
            i1++;
        }
        return i1 == n1 && i2 == n2 + 1;
    }
}
