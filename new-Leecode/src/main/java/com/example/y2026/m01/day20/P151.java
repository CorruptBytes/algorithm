package com.example.y2026.m01.day20;

/**
 * <h1>翻转字符串中的单词</h1>
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class P151 {

        /*
    题意：大家好啊我是电棍->棍电是我啊好家大
    我的答案：欧内的手好汉
     */

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int offset = 0;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            while (i >= 0 && s.charAt(i) != ' ') {
                sb.insert(offset,s.charAt(i));
                i--;
            }
            sb.append(' ');
            offset = sb.length();
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        P151 test = new P151();
        System.out.println(test.reverseWords(s));
    }

}
