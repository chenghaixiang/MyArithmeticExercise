package com.chenghaixiang.jianzhi2.day23;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office068 {
}
//给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//请必须使用时间复杂度为 O(log n) 的算法。
class Solution {
    //二分查找
    //注意这题比普通二分查找多了一个如果没找到返回它将会被按顺序插入的位置。
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int left=0,right=n-1,res=0;
        while (left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid]){
                return res=mid;
            }
            if(target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(left>right){
            return res=left;
        }
        return res;
    }
}