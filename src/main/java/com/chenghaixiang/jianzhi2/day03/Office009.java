package com.chenghaixiang.jianzhi2.day03;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office009 {
}
class Solution02 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length,res=0;
        int sum=1,i=0;
        for(int j=0;j<n;j++){
            sum=sum*nums[j];
            while (i<=j&&sum>=k){
                sum=sum/nums[i];
                i++;
            }
            res=res+j-i+1;
        }
        return res;
    }
}