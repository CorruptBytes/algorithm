package com.example.y2026.m01.day14;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * <h1>复原IP地址</h1>
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，
 * 返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class P93 {
    //通过回溯分隔字符串,效率有点低.
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        List<String> IP = new ArrayList<>(4);
        backtracking(s,results,IP,0);
        return results;
    }
    public void backtracking(String s,List<String> results,List<String> IP,int startIndex) {
        if (IP.size() > 4) return;
        if (startIndex == s.length()) {
            if (IP.size() == 4) results.add(List2IP(IP));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (!isValid(sub)) {
                break;
            }
            IP.add(sub);
            backtracking(s,results,IP,i + 1);
            IP.removeLast();
        }

    }
    public boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        if (s.length() > 3) return false;
        return Integer.parseInt(s) <= 255;
    }
    public String List2IP(List<String> IP) {
        StringJoiner sj = new StringJoiner(".");
        for (String string : IP) {
            sj.add(string);
        }
        return sj.toString();
    }


    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];
    //仍然是回溯
    public List<String> restoreIpAddressesV1(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
            return;
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
