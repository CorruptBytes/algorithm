package com.example.y2026.m02.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>赎金信</h1>
 * <p>给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。</p>
 * <a href="https://leetcode.cn/problems/ransom-note">链接</a>
 */
public class P383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int n1 = ransomNote.length();
        int n2 = magazine.length();
        Map<Character,Integer> mMap = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            mMap.put(magazine.charAt(i),mMap.getOrDefault(magazine.charAt(i),0) + 1);
        }
        Map<Character,Integer> rMap = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            rMap.put(ransomNote.charAt(i),rMap.getOrDefault(ransomNote.charAt(i),0) + 1);
        }
        for (Character c : rMap.keySet()) {
            if (mMap.getOrDefault(c,0) < rMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstructV1(String ransomNote, String magazine) {
        int n1 = ransomNote.length();
        int n2 = magazine.length();
        int[] chars = new int[26];
        for (int i = 0; i < n2; i++) {
            chars[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n1; i++) {
            chars[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] < 0) return false;
        }
        return true;
    }
}
