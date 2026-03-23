package com.example.day47;

import java.util.*;

/**
 * <h1>字母异位词分组</h1>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 */
public class P49 {
    //暴力方法，击败百分之5
    public List<List<String>> groupAnagramsV1(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) continue;
            String s = strs[i];
            result.add(s);
            strs[i] = null;
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j] == null) continue;
                if (isValid(s,strs[j])) {
                    result.add(strs[j]);
                    strs[j] = null;
                }
            }
            results.add(new ArrayList<>(result));
            result.clear();
        }
        return results;
    }
    public boolean isValid(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 97] +=1 ;
        }
        for (int i = 0; i < s2.length(); i++) {
            chars[s2.charAt(i) - 97] -=1 ;
        }
        return Arrays.stream(chars).allMatch(i -> i == 0);
    }

    //使用Hash表记录之前的遍历结果，减少遍历
    public List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            int len = str.length();
            for (int i = 0; i < len; i++) {
                count[str.charAt(i) - 97]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char)('a' + i)).append(count[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
    //不是为什么排序比上面那个还快
    public List<List<String>> groupAnagramsV3(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
