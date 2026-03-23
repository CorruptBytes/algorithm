package com.example.day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * <h1>复原IP地址</h1>
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，
 * 返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class P93 {
    //回溯算法
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return Collections.emptyList();
        }
        List<String> results = new ArrayList<>();
        List<String> IP = new ArrayList<>();
        backtracking(s,results,IP,0);
        return results;
    }
    public void backtracking(String s,List<String> results,List<String> IP,int startIndex) {
        if (IP.size() == 4 && startIndex == s.length()) {
            results.add(format(IP));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex,i + 1);
            if (!isValid(sub)) {
                continue;
            }
            IP.add(sub);
            backtracking(s,results,IP,i + 1);
            IP.remove(IP.size() - 1);
        }
    }
    public boolean isValid(String s) {
        if (s.isEmpty() || s.length() >3) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() != 1) {
            return false;
        }
        return Integer.parseInt(s) <= 255;
    }
    public String format(List<String> IP) {
        StringJoiner sj = new StringJoiner(".");
        for (String s : IP) {
            sj.add(s);
        }
        return sj.toString();
    }
}
