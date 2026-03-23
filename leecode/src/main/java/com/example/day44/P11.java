package com.example.day44;

/**
 * <h1>盛水最多的容器</h1>
 */
public class P11 {

    //通过左指针与右指针表示容器的左右边界，容器的容量是受较小边界影响，因此每次移动较小的边界，以期待容量变大。
    public int maxArea(int[] height) {
        int left = 0;
        int max = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max,Math.min(height[left],height[right]) * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}
