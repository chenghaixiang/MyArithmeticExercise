package com.chenghaixiang.jianzhi1.day08;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office63 {
}
class Solution03{
    public int maxProfit(int[] prices) {
        int max=0;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<prices.length;i++){
            if (prices[i]<min){
                min=prices[i];
            }else if(prices[i]-min>max){
                max=prices[i]-min;
            }
        }
        return max;
    }
}
