package com.example.y2026.m01.day13;

/**
 * <h1>字符串相加</h1>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */
public class P415 {

    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i1 >= 0 || i2 >= 0) {
            char s1 = i1 >= 0 ? num1.charAt(i1--) : '0';
            char s2 = i2 >= 0 ? num2.charAt(i2--) : '0';
            int single = s1 + s2 + carry - '0' - '0';
            carry = single / 10;
            sb.append(single % 10);
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
