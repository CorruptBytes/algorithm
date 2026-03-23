package com.example.day35;

/**
 * <h1>移动零</h1>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class P283 {
    //无敌了，只击败百分之5.我真牛逼
    public void moveZeroes(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                size--;
                i--;
            }
        }
        for (int i = size; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesV1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
