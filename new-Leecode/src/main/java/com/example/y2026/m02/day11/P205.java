package com.example.y2026.m02.day11;

import java.util.HashMap;
import java.util.Map;

/**
 *<h1>同构字符串</h1>
 * <p>给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。</p>
 * <a href="https://leetcode.cn/problems/isomorphic-strings">链接</a>
 */
public class P205 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> map1 = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            Character c = map.get(c1);
            if (c == null) {
                map.put(c1,c2);
                if (map1.containsKey(c2)) {
                    return false;
                } else {
                    map1.put(c2,c1);
                }
            } else {
                if (!c.equals(c2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
