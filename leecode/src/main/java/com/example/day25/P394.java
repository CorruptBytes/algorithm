package com.example.day25;

import java.util.logging.Level;

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
//    //只能处理只有一层[]的字符串
//    public String decodeString(String s) {
//        int len = s.length();
//        int index = 0;
//        StringBuilder sb = new StringBuilder();
//        while (index < len) {
//            char c = s.charAt(index);
//            if (c >= 'a' && c <= 'z') {
//                sb.append(c);
//                index++;
//                while (index < len && s.charAt(index) > 'a' && s.charAt(index) < 'z') {
//                    sb.append(s.charAt(index));
//                    index++;
//                }
//            }
//            if (c >= '0' && c <= '9') {
//                int left = index;
//                index++;
//                while (index < len && s.charAt(index) != '[') {
//                    index++;
//                }
//                int count = Integer.parseInt(s.substring(left, index));
//                index++;
//                left = index;
//                while (index < len && s.charAt(index) != ']') {
//                    index++;
//                }
//                for (int i = 0; i < count; i++) {
//                    sb.append(s, left, index);
//                }
//            }
//            index++;
//        }
//        return sb.toString();
//    }
//    public String decodeString(String s) {
//        if (s.isEmpty()) {
//            return s;
//        }
//        // s[0] 是字母
//        if (Character.isLetter(s.charAt(0))) {
//            // 分离出 s[0]，解码剩下的
//            return s.charAt(0) + decodeString(s.substring(1));
//        }
//        // s[0] 是数字，后面至少有一对括号
//        int i = s.indexOf('['); // 找左括号
//        int balance = 1; // 左括号个数减去右括号个数
//        for (int j = i + 1; ; j++) {
//            char c = s.charAt(j);
//            if (c == '[') {
//                balance++;
//            } else if (c == ']') {
//                balance--;
//                if (balance == 0) { // 找到与 s[i] 匹配的右括号 s[j]
//                    int k = Integer.parseInt(s.substring(0, i));
//                    String t = decodeString(s.substring(i + 1, j));
//                    return t.repeat(k) +
//                            decodeString(s.substring(j + 1));
//                }
//            }
//        }
//    }

    int index = 0;
    public String decodeString(String s) {
        return dfs(s);
    }

    private String dfs(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        while (index < n) {
            char c = s.charAt(index);
            if (Character.isLetter(c)) {
                // 普通字符
                result.append(c);
                index++;
            } else if (Character.isDigit(c)) {
                // 解析数字
                int count = 0;
                while (index < n && Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index++; // 跳过 '['
                String sub = dfs(s); // 递归解析子串
                index++; // 跳过 ']'
                result.append(sub.repeat(count));
            } else if (c == ']') {
                // 子串结束
                break;
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        P394 test = new P394();
        System.out.println(test.decodeString("3[2[a]]"));
    }
}
