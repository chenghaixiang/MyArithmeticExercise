package com.chenghaixiang.jianzhi2.day30;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office088 {
    public static void main(String[] args) {
        int[] a={10,15,20};
        Solution solution=new Solution();
        solution.minCostClimbingStairs(a);
    }
}
//数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
//
//每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
//
//请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
//需要注意题目中所说的“一开始可以选择前2节楼梯”和“到达楼层顶部”
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //cost数组的中的值表示你站在当前阶梯花费当前阶梯所需要的体力就可以往上走一到两步
        int n=cost.length;
        //动态规划数组，表示表示达到下标 i的最小花费。
        //n是第n阶台阶，n+1就是楼顶
        int[] dp = new int[n + 1];
        //由于可以选择下标 0 或 1 作为初始阶梯，因此有 dp[0]=dp[1]=0
        dp[0] = dp[1] = 0;
        //因为在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。所以i=2
        for (int i = 2; i <= n; i++) {
            //状态转移方程
            //因为支付了体力就可以爬一或者二个阶梯
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        //取最后一个元素因为数组初始化时是n，取下标元素时是n-1
        return dp[n];
    }
}