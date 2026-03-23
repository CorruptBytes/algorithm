package com.example.y2026.m02.day8;

import java.util.*;

/**
 * <h1>O(1)时间插入、删除和获取随机元素</h1>
 * <p>实现RandomizedSet 类：
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。</p>
 * <a href="https://leetcode.cn/problems/insert-delete-getrandom-o1">链接</a>
 */
public class P380 {
}
//哈希表加变长数组
class RandomizedSet {
    private Map<Integer,Integer> indices = new HashMap<>();
    private List<Integer> nums = new ArrayList<>();
    Random random = new Random();
    public RandomizedSet() {

    }

    public boolean insert(int val) {
        Integer num = indices.get(val);
        if (num != null) return false;
        int index = nums.size();
        nums.add(index,val);
        indices.put(val,index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.getLast();
        nums.set(index, last);
        indices.put(last, index);
        nums.removeLast();
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }
}