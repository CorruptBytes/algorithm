package com.example.dsu;

public class Dsu {
    private int[] set;
    private int[] height;
    public Dsu(int capacity) {
        set = new int[capacity];
        height = new int[capacity];
        initialize();
    }

    public void initialize() {
        for (int i = 0; i < set.length; i++) {
            set[i] = i;
        }
    }
    public int find(int e) {
        if (set[e] == e) {
            return e;
        } else {
            return find(set[e]);
        }
    }
    //优化find，由于合并后，会出现多层树形结构，因此在查找的回溯过程中将非直接子结点均直接指向根节点。从而压缩查找路径，这称为路径压缩。
    public int find1(int e) {
        if (set[e] == e) {
            return e;
        } else {
            return set[e] = find1(set[e]);
        }
    }

    public void union(int e1, int e2) {
        int r1 = find(e1);
        int r2 = find(e2);
        if (r1 == r2) return;
        if (height[r1] > height[r2]) {
            set[r2] = r1;
        } else if (height[r1] < height[r2]){
            set[r1] = r2;
        } else {
            set[r1] = r2;
            height[r2]++;
        }
    }
}
