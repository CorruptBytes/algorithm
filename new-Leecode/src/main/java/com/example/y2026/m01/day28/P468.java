package com.example.y2026.m01.day28;
/**
 * <h1>验证IP地址</h1>
 * 给定一个字符串 queryIP。
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 */
public class P468 {
    //分情况讨论
    public String validIPAddress(String queryIP) {
        int index = 0;
        int n = queryIP.length();
        if (queryIP.indexOf('.') >= 0) {
            //可能是IPV4
            for (int i = 0; i < 4; i++) {
                int address = 0;
                int start = index;
                while (index < n && Character.isDigit(queryIP.charAt(index)) ) {
                    address = address * 10 + queryIP.charAt(index) - '0';
                    index++;
                }
                if (start == index) {
                    return "Neither";
                }
                if (index - start > 1 && queryIP.charAt(start) == '0') {
                    return "Neither";
                }
                if (address > 255 || index - start > 3) {
                    return "Neither";
                }
                if (index < n && queryIP.charAt(index) != '.') {
                    return "Neither";
                }
                index++;
            }
            if (index == n + 1) {
                return "IPv4";
            } else {
                return "Neither";
            }
        } else {
            //可能是IPV6
            for (int i = 0; i < 8; i++) {
                int start = index;
                while (index < n && (Character.isDigit(queryIP.charAt(index)) || Character.isLetter(queryIP.charAt(index)))) {
                    if (!Character.isDigit(queryIP.charAt(index)) && !('a' <= Character.toLowerCase(queryIP.charAt(index)) && Character.toLowerCase(queryIP.charAt(index)) <= 'f')) {
                        return "Neither";
                    }
                    index++;
                }
                if (index - start > 4 || index - start <= 0) {
                    return "Neither";
                }
                index++;
            }
            if (index == n + 1) {
                return "IPv6";
            } else {
                return "Neither";
            }
        }
    }
}
