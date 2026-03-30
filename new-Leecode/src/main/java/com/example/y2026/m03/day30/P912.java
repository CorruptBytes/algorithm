package com.example.y2026.m03.day30;

import java.util.Arrays;

public class P912 {
    //堆排序
    public void sort(int[] arr) {
        createHeap(arr);
        int len = arr.length;
        while (len > 0) {
            int temp = arr[len - 1];
            arr[len - 1] = arr[0];
            arr[0] = temp;
            len--;
            swap(arr,0, len);
        }

    }

    public void createHeap(int[] arr) {
        int len = arr.length;
        int lastNumber = len / 2;
        while (lastNumber > 0) {
            int index = lastNumber - 1;
            swap(arr, index,len);
            lastNumber--;
        }
    }

    public void swap(int[] arr,int rootIndex,int len) {
        boolean left = false;
        boolean right = false;
        if (rootIndex * 2 + 2 < len) {
            if (arr[rootIndex] < arr[rootIndex * 2 + 1] || arr[rootIndex] < arr[rootIndex * 2 + 2]) {
                if (arr[rootIndex * 2 + 1] < arr[rootIndex * 2 + 2]) {
                    int temp = arr[rootIndex];
                    arr[rootIndex] = arr[rootIndex * 2 + 2];
                    arr[rootIndex * 2 + 2] = temp;
                    right = true;
                } else {
                    int temp = arr[rootIndex];
                    arr[rootIndex] = arr[rootIndex * 2 + 1];
                    arr[rootIndex * 2 + 1] = temp;
                    left = true;
                }
            }
        } else {
            if (rootIndex * 2 + 1 < len) {
                if (arr[rootIndex] < arr[rootIndex * 2 + 1]) {
                    int temp = arr[rootIndex];
                    arr[rootIndex] = arr[rootIndex * 2 + 1];
                    arr[rootIndex * 2 + 1] = temp;
                    left = true;
                }
            }
        }
        if (left) {
            swap(arr, rootIndex * 2 + 1,len);
        } else if (right) {
            swap(arr, rootIndex * 2 + 2,len);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,6,29,2,49};
        P912 test = new P912();
        test.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
