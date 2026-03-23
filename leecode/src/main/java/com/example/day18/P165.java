package com.example.day18;

/**
 * <h1>比较版本号</h1>
 * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。
 * 版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
 */
public class P165 {
    public int compareVersion(String version1, String version2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i1 = 0;
        int i2 = 0;
        while (i1 < version1.length() || i2 < version2.length()) {
            while (i1 < version1.length() && version1.charAt(i1) != '.') {
                sb1.append(version1.charAt(i1));
                i1++;
            }
            while (i2< version2.length() && version2.charAt(i2) != '.') {
                sb2.append(version2.charAt(i2));
                i2++;
            }
            int num1 = Integer.parseInt(sb1.isEmpty() ? sb1.append(0).toString() : sb1.toString());
            int num2 = Integer.parseInt(sb2.isEmpty() ? sb2.append(0).toString() : sb2.toString());
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            sb1.delete(0,sb1.length());
            sb2.delete(0,sb2.length());
            i1++;
            i2++;
        }
        return 0;
    }
}
