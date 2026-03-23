package com.example.day22;

/**
 * <h1>字符串相乘</h1>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */
public class P43 {

    public String multiply(String num1, String num2) {
        if (num1.length() == 1) {
            return subMultiply(num2,num1);
        }
        if (num2.length() == 1) {
            return subMultiply(num1,num2);
        }
        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder plus = new StringBuilder(subMultiply(num1, num2.charAt(i) + ""));
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                plus.append('0');
            }
            result = plus(result,plus.toString());
        }
        return result;
    }
    //实现多位数乘单位数,如23 * 5，1000000 * 3
    public String subMultiply(String multipleNum,String singleNum) {
        if (singleNum.charAt(0) == '0') {
            return "0";
        }
        int num2 = singleNum.charAt(0) - '0';
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = multipleNum.length() - 1; i >= 0 ; i--) {
            int num1 = multipleNum.charAt(i) - '0';
            sb.append((num1 * num2 + carry) % 10);
            carry = (num1 * num2 + carry) / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    //实现两数相加
    public String plus(String num1,String num2) {
        StringBuilder sb = new StringBuilder();
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        while (i1 >= 0 || i2 >= 0) {
            int single1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int single2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;
            sb.append((single1 + single2 + carry) % 10);
            carry = (single1 + single2 + carry) / 10;
            i1--;
            i2--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "23453454325123";
        String num2 = "9";
        P43 test = new P43();
        System.out.println(test.subMultiply(num1,num2));
        String n3 = "123";
        String n4 = "111111";
        System.out.println(test.plus(n3,n4));
    }
}
