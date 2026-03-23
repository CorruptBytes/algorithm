package com.example.y2026.m02.day15;

/**
 * <h1>加一</h1>
 * <p>给定一个表示 大整数 的整数数组 digits，
 * 其中 digits[i] 是整数的第 i 位数字。这些数字按从左到右，从最高位到最低位排列。这个大整数不包含任何前导 0。
 * 将大整数加 1，并返回结果的数字数组。</p>
 * <a href="https://leetcode.cn/problems/plus-one">链接</a>
 */
public class P66 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        int i = n - 1;
        digits[i]++;
        do {
            int single = digits[i];
            single += carry;
            digits[i] = single % 10;
            carry = single / 10;
            i--;
        } while (carry != 0 && i >= 0);
        if (carry != 0) {
            int[] newArray = new int[n + 1];
            newArray[0] = 1;
            System.arraycopy(digits,0,newArray,1,n);
            return newArray;
        }
        return digits;
    }
}
