package com.example.day37;

/**
 * <h1>验证IP地址</h1>
 * 给定一个字符串 queryIP。
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 */
public class P468 {
    //简单方法，直接问AI正则表达式怎么写，通过正则匹配.
//    public String validIPAddress(String queryIP) {
//        if (queryIP == null) {
//            return "Neither";
//        }
//
//        String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
//        String regexIPv4 = regex0 + "(\\." + regex0 + "){3}";
//        String regex1 = "([\\da-fA-F]{1,4})";
//        String regexIPv6 = regex1 + "(:" + regex1 + "){7}";
//
//        String result = "Neither";
//        if (queryIP.matches(regexIPv4)) {
//            result = "IPv4";
//        } else if (queryIP.matches(regexIPv6)) {
//            result = "IPv6";
//        }
//        return result;
//    }
        //遍历字符串,分情况判断.
        public String validIPAddress(String queryIP) {
            if (queryIP.indexOf('.') >= 0) {
                // IPv4
                int last = -1;
                for (int i = 0; i < 4; ++i) {
                    int cur = (i == 3 ? queryIP.length() : queryIP.indexOf('.', last + 1));
                    if (cur < 0) {
                        return "Neither";
                    }
                    if (cur - last - 1 < 1 || cur - last - 1 > 3) {
                        return "Neither";
                    }
                    int addr = 0;
                    for (int j = last + 1; j < cur; ++j) {
                        if (!Character.isDigit(queryIP.charAt(j))) {
                            return "Neither";
                        }
                        addr = addr * 10 + (queryIP.charAt(j) - '0');
                    }
                    if (addr > 255) {
                        return "Neither";
                    }
                    if (addr > 0 && queryIP.charAt(last + 1) == '0') {
                        return "Neither";
                    }
                    if (addr == 0 && cur - last - 1 > 1) {
                        return "Neither";
                    }
                    last = cur;
                }
                return "IPv4";
            } else {
                // IPv6
                int last = -1;
                for (int i = 0; i < 8; ++i) {
                    int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(':', last + 1));
                    if (cur < 0) {
                        return "Neither";
                    }
                    if (cur - last - 1 < 1 || cur - last - 1 > 4) {
                        return "Neither";
                    }
                    for (int j = last + 1; j < cur; ++j) {
                        if (!Character.isDigit(queryIP.charAt(j)) && !('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f')) {
                            return "Neither";
                        }
                    }
                    last = cur;
                }
                return "IPv6";
            }
        }
}
