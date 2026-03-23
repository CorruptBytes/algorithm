package com.example.day31;

/**
 * <h1>最长公共前缀</h1>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class P14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int size = Integer.MAX_VALUE;
        for (String str : strs) {
         size = Math.min(size,str.length());
        }
        for (int i = 0; i < size; i++) {
            char c = strs[0].charAt(i);
            boolean flag = true;
            for (String str : strs) {
                if (c != str.charAt(i)) {
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
