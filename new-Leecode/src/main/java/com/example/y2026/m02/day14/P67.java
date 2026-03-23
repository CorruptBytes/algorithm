package com.example.y2026.m02.day14;

/**
 * <h1>二进制求和</h1>
 * <p>给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。</p>
 * <a href="https://leetcode.cn/problems/add-binary">链接</a>
 */
public class P67 {

    public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int n = Math.max(la,lb);
        int carry = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            int num1 = i < a.length() ? a.charAt(la - i - 1) - '0' : 0;
            int num2 = i < b.length() ? b.charAt(lb - i - 1) - '0' : 0;
            int num = num1 + num2 + carry;
            carry = num / 2;
            sb.append(num % 2);
            i++;
        }
        if (carry != 0) sb.append(1);
        return sb.reverse().toString();
    }
}
