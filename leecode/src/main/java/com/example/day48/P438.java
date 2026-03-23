package com.example.day48;

import java.util.*;
import java.util.function.IntPredicate;

/**
 *
 * <h1>找到字符串中所有字母异位词</h1>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 */
public class P438 {

    public List<Integer> findAnagramsV1(String s, String p) {
        if (s.length() < p.length() || s.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        set.add(new String(chars));
        int left = 0;
        int right = 1;
        int len1 = p.length();
        int len2 = s.length();
        while (right <= len2) {
            if (right - left < len1) {
                right++;
            } else {
                char[] temp = s.substring(left, right).toCharArray();
                Arrays.sort(temp);
                String string = new String(temp);
                if (!set.add(string)) {
                    list.add(left);
                } else {
                    set.remove(string);
                }
                left++;
            }
        }
        return list;
    }
    //击败百分之20，这群傻逼怎么写的
    public List<Integer> findAnagramsV2(String s, String p) {
        if (s.length() < p.length() || s.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int left = 0;
        int right = 0;
        int len1 = p.length();
        int len2 = s.length();
        for (int i = 0; i < p.length(); i++) {
            count1[p.charAt(i) - 97]++;
        }
        while (right < len2) {
            count2[s.charAt(right) - 97]++;
            if (right - left + 1 == len1) {
                boolean allMatch = Arrays.stream(count1).allMatch(new IntPredicate() {
                    int i = -1;
                    @Override
                    public boolean test(int value) {
                        i++;
                        return value == count2[i];
                    }
                });
                if (allMatch) list.add(left);
                count2[s.charAt(left) - 97]--;
                left++;
            }
            right++;
        }
        return list;
    }

    public List<Integer> findAnagramsV3(String s, String p) {
        int len1 = p.length();
        int len2 = s.length();
        if (len2 < len1 || len2 == 0) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < len1; i++) {
            count1[p.charAt(i) - 97]++;
            count2[s.charAt(i) - 97]++;
        }
        if (Arrays.equals(count1,count2)) list.add(0);
        for (int i = 0; i < len2 - len1; i++) {
            count2[s.charAt(i) - 97]--;
            count2[s.charAt(i + len1) - 97]++;
            if (Arrays.equals(count1,count2)) list.add(i + 1);
        }
        return list;
    }
}
