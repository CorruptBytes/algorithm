package com.example.y2026.m04.day3;

public class P50 {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }
        double res = x;
        int count = 1;
        while (n - (count + count) > 0) {
            res *= res;
            count += count;
        }
        n -= count;
        while (n > 0) {
            res *= x;
            n--;
        }
        return res;
    }
    public double myPow1(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }

        int count = 1;
        double res = x;
        double pre = 1;
        while (n - count > 0) {
            double temp = res;
            res *= pre;
            pre = temp;
            count += (count - 1);
        }
        count = count - n;
        while (count > 0) {
            res /= x;
        }
        return res;
    }
    public double myPow2(double x,int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    public double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
