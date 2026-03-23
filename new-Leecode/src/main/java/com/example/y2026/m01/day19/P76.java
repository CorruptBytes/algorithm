package com.example.y2026.m01.day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <h1>最小覆盖子串</h1>
 * 给你一个字符串 s 、一个字符串 t 。
 * 返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 */
public class P76 {

    public String minWindow(String s, String t) {
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c,tMap.getOrDefault(c,0) + 1);
        }
        int left = 0;
        int right = 0;
        int targetL = -1;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (tMap.containsKey(c)) {
                window.put(c,window.getOrDefault(c,0) + 1);
            }
            while (check(tMap,window) && left <= right) {
                if (right - left + 1 < len) {
                    targetL = left;
                    len = right - left + 1;
                }
                if (tMap.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
            right++;
        }
        return targetL == - 1 ? "" : s.substring(targetL,targetL + len);
    }

    public boolean check(Map<Character,Integer> ori,Map<Character,Integer> cont) {
        for (Map.Entry<Character, Integer> characterIntegerEntry : ori.entrySet()) {
            Map.Entry entry = (Map.Entry) characterIntegerEntry;
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cont.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
