package com.chenghaixiang.jianzhi2.day04;

import java.util.HashMap;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office011 {
}
//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
class Solution01 {
    public int findMaxLength(int[] nums) {
        int maxleng=0;
        //key是前缀和，value是位置
        HashMap<Integer,Integer> map=new HashMap<>();
        //前缀和
        int count=0;
        //规定空的前缀的结束下标为 −1，由于空的前缀的元素和为 0
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(num==1){
                count++;
            }else {
                count--;
            }
            if(map.containsKey(count)){
                int pre=map.get(count);
                maxleng=Math.max(maxleng,i-pre);
            }else {
                map.put(count,i);
            }

        }
        return maxleng;
    }
}