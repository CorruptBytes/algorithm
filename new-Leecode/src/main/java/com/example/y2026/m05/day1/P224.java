package com.example.y2026.m05.day1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <h1>基本计算器</h1>
 * <p>给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。</p>
 * <a href="https://leetcode.cn/problems/basic-calculator">链接</a>
 */
public class P224 {
    /*
    首先考虑比较简单的逆波兰表达式写法
    1.先将中缀表达式转换为逆波兰表达式
    2.使用栈计算逆波兰表达式
     */
    public int calculate(String s) {
        int n = s.length();

        Stack<Character> ops = new Stack<>();
        List<String> tokens = new ArrayList<>();

        int i = 0;
        boolean prevIsOp = true; // 用于判断一元负号

        while (i < n) {
            char c = s.charAt(i);

            if (c == ' ') {
                i++;
                continue;
            }

            // =========================
            // 数字
            // =========================
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num.append(s.charAt(i));
                    i++;
                }
                tokens.add(num.toString());
                prevIsOp = false;
                continue;
            }

            // =========================
            // 左括号
            // =========================
            if (c == '(') {
                ops.push(c);
                i++;
                prevIsOp = true;
                continue;
            }

            // =========================
            // 右括号
            // =========================
            if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    tokens.add(ops.pop() + "");
                }
                ops.pop(); // 弹出 '('
                i++;
                prevIsOp = false;
                continue;
            }

            // =========================
            // + -
            // =========================
            if (c == '+' || c == '-') {

                // ⭐⭐⭐ 一元负号：补零
                if (c == '-' && prevIsOp) {
                    tokens.add("0");
                }

                while (!ops.isEmpty() && ops.peek() != '(') {
                    tokens.add(ops.pop() + "");
                }

                ops.push(c);
                i++;
                prevIsOp = true;
            }
        }

        // 清空栈
        while (!ops.isEmpty()) {
            tokens.add(ops.pop() + "");
        }

        // debug 输出 RPN
        for (String t : tokens) {
            System.out.print(t + " ");
        }
        System.out.println();

        // =========================
        // RPN 计算
        // =========================
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
    //将括号前的符号贯穿到括号内从而不用考虑括号带来的优先级问题
    public int calculateV1(String s) {
        Stack<Integer> signStack = new Stack<>(); // 只存符号上下文

        int ans = 0;   // 累计结果
        int num = 0;   // 当前数字
        int sign = 1;  // 当前符号（+1 / -1）

        // 初始符号环境
        signStack.push(1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                continue;
            }
            if (c == '+' || c == '-') {
                // 先结算上一个数字
                ans += sign * num;
                num = 0;
                // 更新当前符号（受括号影响）
                sign = (c == '+') ? signStack.peek() : -signStack.peek();
                continue;
            }
            if (c == '(') {
                // 左括号
                // 把当前符号环境压栈
                signStack.push(sign);
            }
            else if(c == ')') {
                // 右括号
                signStack.pop();
            }
        }

        // 收尾
        ans += sign * num;

        return ans;
    }


}
