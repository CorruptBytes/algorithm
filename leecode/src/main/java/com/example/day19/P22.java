package com.example.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <h1>括号生成</h1>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class P22 {
    //尝试回溯解法,时间复杂度过高，可以优化
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking(results,sb,n);
        return results;
    }
    public void backtracking(List<String> results,StringBuilder sb,int n) {
        if (sb.length() == 2 * n ) {
            if (isValid(sb.toString())) {
                results.add(sb.toString());
            }
            return;
        }
        sb.append("(");
        backtracking(results,sb,n);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        backtracking(results,sb,n);
        sb.deleteCharAt(sb.length() - 1);
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
