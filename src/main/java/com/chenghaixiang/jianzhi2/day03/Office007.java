package com.chenghaixiang.jianzhi2.day03;

import java.util.*;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office007 {
}
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null||nums.length<3){
            return new ArrayList<>();
        }
        //因为题目要求不重复
        Set<List<Integer>> res=new HashSet<>();

        //按从小到大排序
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            //三数相加等于0，即两数相加等于这个数的相反数
            int target=-nums[i];
            //双指针
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int sum=nums[left]+nums[right];
                if(sum==target){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }else if(sum<target){
                    left++;
                }else {
                    right--;
                }
            }

        }
        return new ArrayList<>(res);
    }
}