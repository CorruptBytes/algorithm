package com.example.y2026.m01.day26;

import java.util.Stack;

/**
 * <h1>基本计算器Ⅱ</h1>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 */
public class P227 {

    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> nums = new Stack<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (preSign) {
                    case '+' -> {nums.push(num);}
                    case '-' -> {nums.push(-num);}
                    case '*' -> {nums.push(nums.pop() * num);}
                    default -> {nums.push(nums.pop() / num);}
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!nums.isEmpty()) {
            ans += nums.pop();
        }
        return ans;
    }
}
