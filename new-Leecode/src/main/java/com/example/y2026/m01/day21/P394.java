package com.example.y2026.m01.day21;

import java.sql.ResultSet;

/**
 * <h1>字符串解码</h1>
 * <p>给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 测试用例保证输出的长度不会超过 105。</p>
 * <a href="https://leetcode.cn/problems/decode-string">链接</a>
 */
public class P394 {
    int index = 0;
    public String decodeString(String s) {
        return dfs(s);
    }

    private String dfs(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        while (index < n) {
            char c = s.charAt(index);
            if (Character.isLetter(c)) {
                sb.append(c);
                index++;
                continue;
            }
            if (Character.isDigit(c)) {
                int count = 0;
                while (index < n && Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                //跳过左括号
                index++;
                String sub = dfs(s);
                sb.append(sub.repeat(count));
            } else if (c == ']') {
                //跳过右括号
                index++;
                break;
            }

        }
        return sb.toString();
    }

    public String decodeStringV1(String s) {
        int n = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int k = c - '0';
                i++;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    k = k * 10 + (s.charAt(i) - '0');
                    i++;
                }
                //跳过左括号
                i++;
                int start = i;
                int left = 1;
                int right = 0;
                while (i < n && left != right) {
                    if (s.charAt(i) == '[') left++;
                    if (s.charAt(i) == ']') right++;
                    i++;
                }
                String sub = decodeStringV1(s.substring(start,i - 1));
                for (int j = 0; j < k; j++) {
                    sb.append(sub);
                }
            } else {
                sb.append(c);
                i++;
                while (i < n && Character.isLetter(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
            }
        }
        return sb.toString();
    }
}
