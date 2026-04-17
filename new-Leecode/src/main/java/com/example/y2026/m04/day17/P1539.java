package com.example.y2026.m04.day17;

public class P1539 {
    public int findKthPositive(int[] arr,int k) {
        int len = arr.length;
        //二分查找
        int low = 0,high = len - 1;
        int mid = -1;
        //左闭右闭
        while (low < high) {
            mid = low + (high - low) / 2;
            int pivot = arr[mid];
            int n = pivot - mid - 1;
            if (n < k) {
                high = mid;
            } else if (n == k) {
                break;
            } else {
                low = mid;
            }
        }
        if (low == high) {
            return arr[mid] + k;
        } else {
            
        }

    }
}
