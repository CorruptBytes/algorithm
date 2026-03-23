package com.example.y2026.m02.day9;

/**
 * <h1>最后一个单词的长度</h1>
 * <p>给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。</p>
 * <a href="https://leetcode.cn/problems/length-of-last-word/description">链接</a>
 */
public class P58 {

    public int lengthOfLastWord(String s) {
        int last = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            last = 0;
            while (i < n && s.charAt(i) != ' ') {
                i++;
                last++;
            }
        }
        return last;
    }
    //我是智障吗，反向遍历不就可以了
    public int lengthOfLastWordV1(String s) {
        int last = 0;
        int n = s.length();
        int i = s.length() - 1;
        while (i >= 0 && last == 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            last = 0;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
                last++;
            }
        }
        return last;
    }
}
