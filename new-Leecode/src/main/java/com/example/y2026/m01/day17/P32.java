package com.example.y2026.m01.day17;

/**
 * <h1>最长有效括号</h1>
 * <p>给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
 * 左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。</p>
 * <a href="https://leetcode.cn/problems/longest-valid-parentheses">链接</a>
 */
public class P32 {

    /*
   有效括号保证其任意前缀的左括号数均大于右括号数，且最终左右括号数相等。
   首先从左到有统计左右括号数，如果某个前缀的右括号数大于左括号数，
   则说明以其为前缀的括号字符串不可能为有效括号，直接将这个前缀舍弃
   重新计算。但是这种方法无法统计出形如"(()"的最长括号，这种括号字符串的所有前缀
   的左括号数都大于右括号数，但是左括号与右括号一直不相等。
   此时在从右向左逆向遍历字符串，就可以优先统计")"，如果左括号数大于右括号数则舍弃。
    */
    public int longestValidParentheses(String s) {
       int left = 0,right = 0, max = 0;
       int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) max = Math.max(max,left * 2);
            else if (right > left) left = right = 0;
        }
        left = right = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) max = Math.max(max,left * 2);
            else if (left > right) left = right = 0;
        }
        return max;
    }
}
