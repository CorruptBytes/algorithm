package com.example.day46;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <h1>最接近的三数之和</h1>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 */
public class P16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int Ri = 0,Rj = 1,Rk = 2;
        int min = Math.abs(nums[0] + nums[1] + nums[2] - target);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp == target) return target;
                if (Math.abs(temp - target) < min) {
                    min = Math.abs(temp - target);
                    Ri = i;Rj = j;Rk = k;
                }
                if (temp > target) k--;
                else j++;
            }
        }
        return nums[Ri] + nums[Rj] + nums[Rk];
    }
}
