package com.example.day23;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <h1>最小覆盖子串</h1>
 * 给你一个字符串 s 、一个字符串 t 。
 * 返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 */
public class P76 {
    //滑动窗口
    public String minWindow(String s, String t) {
        Map<Character,Integer> ori = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c,0) + 1);
        }
        Map<Character,Integer> cont = new HashMap<>(ori.size());
        int l = 0,r = 0;
        int targetL = -1;
        int len = Integer.MAX_VALUE;
        while (r < s.length()) {
            if (ori.containsKey(s.charAt(r))) {
                cont.put(s.charAt(r),cont.getOrDefault(s.charAt(r),0) + 1);
            }
            while (check(ori,cont) && l <= r) {
                if (r - l + 1 < len) {
                    targetL = l;
                    len = r - l + 1;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cont.put(s.charAt(l), cont.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
            r++;
        }
        return targetL == - 1 ? "" : s.substring(targetL,targetL + len);
    }
    public boolean check(Map<Character,Integer> ori,Map<Character,Integer> cont) {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cont.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
