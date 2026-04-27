package com.example.y2026.m01.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>括号生成</h1>
 * <p>数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。</p>
 * <a href="https://leetcode.cn/problems/generate-parentheses">链接</a>
 */

public class P22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking(result,n,0,0,sb);
        return result;
    }

    public void backtracking(List<String> result,int n,int left,int right,StringBuilder sb) {
        if (left == right && left == n) {
            result.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            backtracking(result,n,left + 1,right,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            backtracking(result,n,left,right + 1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
