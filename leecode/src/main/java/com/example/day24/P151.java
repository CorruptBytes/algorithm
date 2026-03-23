package com.example.day24;

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
        int len = s.length();
        int index = len - 1;
        //去除尾随空格
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0) {
            int right = index;
            int left = index;
            //左移index直到遇见空格
            while (index >= 0 && s.charAt(index) != ' ') {
                left = index;
                index--;
            }
            //添加一个单词
            sb.append(s, left, right + 1).append(' ');
            //去除中间空格
            while (index >= 0 && s.charAt(index) == ' ') {
                index--;
            }
        }
        //移除最后多添加的一个空格
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
