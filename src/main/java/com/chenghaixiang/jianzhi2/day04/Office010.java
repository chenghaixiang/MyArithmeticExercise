package com.chenghaixiang.jianzhi2.day04;

import java.util.HashMap;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office010 {
}
//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
class Solution {
    //使用前缀和方法,具体操作看leetcode
    public int subarraySum(int[] nums, int k) {
        //pre表示前缀和
        int cout=0,pre=0;
        //key是前缀和，value是个数
        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre=pre+nums[i];
            //pre-k：pre可以看成从下标0到i的距离，如果pre-k存在证明从某处下标开始+k正好等于到i地方
            if(map.containsKey(pre-k)){
                cout=cout+map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return cout;
    }
}