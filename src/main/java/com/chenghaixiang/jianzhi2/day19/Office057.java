package com.chenghaixiang.jianzhi2.day19;

import java.util.TreeSet;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office057 {
}
//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
//
//如果存在则返回 true，不存在返回 false。
class Solution01 {
    //滑动窗口,k即是窗口大小
    //在每个元素x的前面最多k个元素中找，是否满足在[x-t],[x+t]区间中，（abs(nums[i] - nums[j]) <= t,等价于[x-t],[x+t]，x是num[i]，求num[j]
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //有序集合，自动排序,查找遍历时间复杂度低
        TreeSet<Long> set=new TreeSet<>();
        //用Long是因为为防止整型 int 溢出
        for (int i=0;i<nums.length;i++){
            //ceiling(E e) 返回此集合中最小元素大于或等于给定元素，如果没有此元素，则返回 null 。
            //celling>=nums[i]-t,即[x-t]
            Long celling=set.ceiling((long)nums[i]-(long)t);
            //celling<=((long)nums[i]+(long)t),即[x+t]
            if(celling!=null&&celling<=((long)nums[i]+(long)t)){
                return true;
            }
            set.add((long)nums[i]);
            //超过窗口大小移除值
            if (i >= k) {
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}