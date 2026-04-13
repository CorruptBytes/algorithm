package com.example.y2026.m04.day7;
/** 
 * <h1>环形子数组的最大和</h1>
 */
public class P918 {
    //先采用暴力解法，枚举起点，计算所有可能
    public int maxSubarraySumCircular (int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < len ; i++) {
            int sum = nums[i];
            for(int j = 1;j < len; j++) {
                sum += nums[(i + j) % len];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
    /*
    结果可能存在两种形式:1.普通的最小子数组和。2.跨越头尾的最小子数组和
    如果是跨越头尾的最小子数组和，其最大值等价于头尾之间形成的子数组的最小值(注意计算最小值时，可能最小值等于整个数组的和，此时相减后为空子数组，不符合题意)
     */
    public int maxSubarraySumCircularV2(int[] nums) {
        int len = nums.length;
        int max= Integer.MIN_VALUE;
        int sum = 0;
        //求普通数组的最大子数组和
        for(int i = 0 ; i < len ; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum <= 0) {
                sum = 0;
            }
        }
        //求普通数组的最小子数组和
        int min = Integer.MAX_VALUE;
        sum = 0;
        int all = 0;
        for(int i = 0 ; i < len ; i++) {
            sum += nums[i];
            all += nums[i];
            min = Math.min(min, sum);
            if (sum >= 0) {
                sum = 0;
            }
        }
        if (sum == all) return max;
        return Math.max(max, all - min);
    }

}
