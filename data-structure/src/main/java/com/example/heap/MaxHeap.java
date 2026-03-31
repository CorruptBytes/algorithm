package com.example.heap;

public class MaxHeap {

    int[] heap;
    int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }
    public void buildHeap(int[] arr) {
        heap = arr;
        size = arr.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    // 插入元素
    public void push(int val) {
        heap[size] = val;
        siftUp(size);
        size++;
    }

    // 删除堆顶（最大值）
    public int pop() {
        int res = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return res;
    }

    // 查看堆顶
    public int peek() {
        return heap[0];
    }

    // ================= 核心操作 =================

    // 向上调整（插入用）
    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[parent] >= heap[i]) break;
            swap(parent, i);
            i = parent;
        }
    }

    // 向下调整（删除 / 建堆用）
    private void siftDown(int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest == i) break;

            swap(i, largest);
            i = largest;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
