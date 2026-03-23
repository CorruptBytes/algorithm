package com.example.y2026.m01.day24;
/**
 * <h1>最长公共前缀</h1>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class P14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int min = strs[0].length();
        for (String str : strs) {
            min = Math.min(str.length(),min);
        }
        for (int i = 0; i < min; i++) {
            boolean flag = true;
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(c);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
