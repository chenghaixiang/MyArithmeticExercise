package com.chenghaixiang.jianzhi2.day03;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office008 {
}
//给定一个含有 n 个正整数的数组和一个正整数 target 。
class Solution01 {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        int start=0,end=0;
        int sum=0;
        while (end<n){
            sum=sum+nums[end];
            while (sum>=target){
                res=Math.min(res,end-start+1);
                sum=sum-nums[start];
                start++;
            }
            end++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}