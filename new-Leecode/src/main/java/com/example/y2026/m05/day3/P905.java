package com.example.y2026.m05.day3;

public class P905 {

    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] % 2 == 0) {
                l++;
            }
            while (l < r && nums[r] % 2 == 1) {
                r--;
            }
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            l++;
            r--;
        }
        return nums;
    }
}
