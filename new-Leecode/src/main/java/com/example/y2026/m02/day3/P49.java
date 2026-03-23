package com.example.y2026.m02.day3;


import java.util.*;

/**
 * <h1>字母异位词分组</h1>
 * <p>给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。</p>
 * <a href="https://leetcode.cn/problems/group-anagrams/">链接</a>
 */
public class P49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>(strs.length);
        int[] counts = new int[26];
        for (String str : strs) {
            int n = str.length();
            for (int i = 0; i < n; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    sb.append((char) ('a' + i)).append(counts[i]);
                }
            }
            Arrays.fill(counts,0);
            map.computeIfAbsent(sb.toString(),k -> new LinkedList<>()).add(str);
        }
        return map.values().stream().toList();
    }

    //排序
    public List<List<String>> groupAnagramsV1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            map.computeIfAbsent(key,k -> new LinkedList<>()).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
