package com.chenghaixiang.jianzhi1.day13;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office57 {
}
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
class Solution01{
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int sum=0;
        while (i<j){
            sum=nums[i]+nums[j];
            if(sum<target){
                i++;
            }else if(sum>target){
                j--;
            }else {
                return new int[] {nums[i],nums[j]};
            }
        }
        return new int[0];
    }
}