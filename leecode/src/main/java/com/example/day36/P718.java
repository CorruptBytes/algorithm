package com.example.day36;

/**
 * <h1>最长重复子数组</h1>
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class P718 {
    //感觉可以用动态规划,dp[i][j]表示nums1以i结尾的子数组和num2以j结尾的子数组的最长公共后缀。
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        int result = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
               dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j -1] + 1 : 0;
               result = Math.max(dp[i][j],result);
            }
        }
        return result;
    }
//    public int findLength(int[] nums1, int[] nums2) {
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//        int[] dp = new int[n2 + 1];
//        int result = 0;
//        for (int i = 1; i <= n1; i++) {
//            // 必须倒序，否则会覆盖 dp[j-1] 导致错误
//            for (int j = n2; j >= 1; j--) {
//                if (nums1[i - 1] == nums2[j - 1]) {
//                    dp[j] = dp[j - 1] + 1;
//                } else {
//                    dp[j] = 0;
//                }
//                result = Math.max(result, dp[j]);
//            }
//        }
//        return result;
//    }

    //滑动窗口
    public int findLengthV1(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

}
