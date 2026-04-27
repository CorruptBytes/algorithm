package com.example.y2026.m04.day25;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>电话号码的字母组合</h1>
 * <p>给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number">链接</a>
 */
public class P17 {

    public List<String> letterCombinations(String digits) {
        String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        backtracking(digits,0,new StringBuilder(),res,map);
        return res;
    }

    public void backtracking(String digits,int index, StringBuilder sb, List<String> res,String[] map) {
        if (digits.length() == sb.length()) {
            res.add(sb.toString());
            return;
        }
        String s = map[digits.charAt(index) - '2'];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i));
            backtracking(digits,index + 1,sb,res,map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
