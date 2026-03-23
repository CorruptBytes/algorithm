package com.example.y2026.m02.day9;

/**
 * <h1>验证回文串</h1>
 * <p>如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
 * 短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。</p>
 * <a href="https://leetcode.cn/problems/valid-palindrome/description">链接</a>
 */
public class P125 {
    //先写一个简单的，处理完后再检验
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
            if ('0' <= c && c <= '9') sb.append(c);
            i++;
        }
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l++) != sb.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
    //目测可以边处理边校验
    public boolean isPalindromeV1(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char lChar = s.charAt(l);
            while (l < r && !Character.isLetterOrDigit(lChar)) {
                lChar = s.charAt(++l);
            }
            char rChar = s.charAt(r);
            while (l < r && !Character.isLetterOrDigit(rChar)) {
                rChar = s.charAt(--r);
            }
            if (lChar != rChar) {
                if (!Character.isLetter(lChar) || !Character.isLetter(rChar) || Math.abs(lChar - rChar) != 32) {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int)'0' - (int)'P');
    }
}
