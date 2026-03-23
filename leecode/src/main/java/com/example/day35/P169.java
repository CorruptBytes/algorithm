package com.example.day35;

/**
 * <h1>多数元素</h1>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素
 */
public class P169 {
    //首先使用哈希表解，时间复杂度为O(n),空间复杂度为O(n)
//    public int majorityElement(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        int count = nums.length / 2;
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > count) {
//                return entry.getKey();
//            }
//        }
//        return 0;
//    }

    /**
     * 如果一个数组有大于一半的数相同，那么任意删去两个不同的数字，新数组还是会有相同的性质。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
