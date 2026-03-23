package com.example.y2026.m02.day18;

/**
 * <h1>阶乘后的零</h1>
 * <p>给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 * </p>
 * <a href="https://leetcode.cn/problems/factorial-trailing-zeroes">链接</a>
 */
public class P172 {
    public int trailingZeroes(int n) {
        int count2 = 0;
        int count5 = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp % 2 == 0) {
                count2++;
                temp >>>= 1;
            }
            temp = i;
            while (temp % 5 == 0) {
                count5++;
                temp /= 5;
            }
        }
        return Math.min(count2,count5);
    }

    /**
     * n! 尾零的数量即为 n! 中因子 10 的个数，而 10=2×5，因此转换成求 n! 中质因子 2 的个数和质因子 5 的个数的较小值。
     * [1,n] 中 p 的倍数有 n1 = ⌊n / p⌋,他们贡献了n1个质因子，[1,n]中p**2的倍数有 n2 = ⌊n / p ** 2⌋
     * 他们贡献了2 * n2个质因子，但有一些已经在n1中统计，所以只需要考虑n2即可。依次类推，可以获得[1,n]中质因子p的个数
     * 为⌊n / p ** k⌋相加。
     * 可以看出2的质因子个数一定大于等于5
     */
    public int trailingZeroesV1(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
