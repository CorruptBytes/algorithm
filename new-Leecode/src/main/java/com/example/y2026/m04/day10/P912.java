package com.example.y2026.m04.day10;

/**
 * <h1>排序数组</h1>
 * 归并排序
 */
public class P912 {
    public void srotArray(int[] arr) {
        int size = 1;
        int len = arr.length;
        int[] temp = new int[len];
        while (size < len) {
            for(int i = 0; i < len; i += 2 * size) {
                mergeSonArray(arr, i, i + size, i + size, Math.min(len,2 * size + i), temp);
            }
            size *= 2;
            int[] temp1 = temp;
            temp = arr;
            arr = temp1;
        }
        if ((int) Math.log(size) % 2 != 0) {
            arr = temp;ew
        }
    }
    //start与end为左闭右开
    public void mergeSonArray(int[] arr,int start1, int end1, int start2, int end2, int[] target) {
        int targetIndex = start1;
        int i1 = start1;
        int i2 = start2;
        while (i1 < end1 && i2 < end2) {
            if (arr[i1] <= arr[i2]) {
                target[targetIndex++] = arr[i1++];
            } else {
                target[targetIndex++] = arr[i2++];
            }
        }
        if (i1 < end1) {
            System.arraycopy(arr,i1,target,targetIndex,end1 - i1);
        } else {
            System.arraycopy(arr,i2,target, targetIndex,end2 - i2);
        }
    }

}