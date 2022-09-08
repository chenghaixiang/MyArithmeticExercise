package com.chenghaixiang.jianzhi1.day09;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office42 {
    public static void main(String[] args) {
        int[] bb={-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution=new Solution();
        int max=solution.maxSubArray(bb);
        System.out.println(max);
    }
}
//动态规划，求连续子数组的最大和
//转移方程： 若 dp[i−1]≤0dp[i-1] \leq 0dp[i−1]≤0 ，说明 dp[i−1]dp[i - 1]dp[i−1] 对 dp[i]dp[i]dp[i] 产生负贡献，即 dp[i−1]+nums[i]dp[i-1] + nums[i]dp[i−1]+nums[i] 还不如 nums[i]nums[i]nums[i] 本身大。
//当 dp[i−1]>0dp[i - 1] > 0dp[i−1]>0 时：执行 dp[i]=dp[i−1]+nums[i]dp[i] = dp[i-1] + nums[i]dp[i]=dp[i−1]+nums[i] ；
//当 dp[i−1]≤0dp[i - 1] \leq 0dp[i−1]≤0 时：执行 dp[i]=nums[i]dp[i] = nums[i]dp[i]=nums[i] ；
//下面此方法是为了节省空间，原地修改数组
class Solution {
    public int maxSubArray(int[] nums) {
        int nummax=nums[0];
        for (int i=1;i<nums.length;i++){
            if(nums[i-1]<0){
                nums[i]=nums[i];
                nummax=Math.max(nummax,nums[i]);
            }else {
                nums[i]=nums[i]+nums[i-1];
                nummax=Math.max(nummax,nums[i]);
            }
        }
        return nummax;
    }
}
