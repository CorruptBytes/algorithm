package com.example.y2026.m04.day17;

public class P1539 {
    //O(n)复杂度，依次遍历
    public int findKthPositive(int[] arr,int k) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int last = 0;
            if (i == 0) {
                last = arr[i] - 1;
            } else{
                last = arr[i] - arr[i - 1] - 1;
            }
            if (k <= last) {
                return i == 0 ? k : arr[i - 1] + k;
            }
            k -= last;
        }
        return arr[len - 1] + k;
    }
    //考虑使用二分查找进行优化
    public int findKthPositiveV1(int[] arr,int k) {
        
    }
}
