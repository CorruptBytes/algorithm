package com.example.day34;

import java.util.Stack;

/**
 * <h1>基本计算器Ⅱ</h1>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 */
public class P227 {
    //通过栈解决，记录数前面的运算符。
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (preSign) {
                    case '+' -> {stack.push(num);}
                    case '-' -> {stack.push(-num);}
                    case '*' -> {stack.push(stack.pop() * num);}
                    default -> {stack.push(stack.pop() / num);}
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "3+2*2";
        P227 test = new P227();
        System.out.println(test.calculate(s));
    }
}
