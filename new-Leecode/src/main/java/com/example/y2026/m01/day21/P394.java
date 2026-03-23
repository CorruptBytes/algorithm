package com.example.y2026.m01.day21;

import java.sql.ResultSet;

/**
 * <h1>字符串解码</h1>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 测试用例保证输出的长度不会超过 105。
 *
 *
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
}
