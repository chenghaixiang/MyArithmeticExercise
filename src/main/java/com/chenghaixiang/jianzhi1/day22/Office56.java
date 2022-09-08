package com.chenghaixiang.jianzhi1.day22;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office56 {
    public static void main(String[] args) {
        int[] sum={4,1,4};
        Solution solution=new Solution();
        solution.singleNumbers(sum);
    }
}
//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
class Solution {
    public int[] singleNumbers(int[] nums) {
        int x=0,y=0,n=0,m=1;
        for (int num:nums){
            n=n^num;
        }
        //将数组划分成两个子数组的基准值
        while ((n&m)==0){
            m<<=1;
        }
        //划分数组
        for (int num:nums){
            if((num&m)!=0){
                x=x^num;
            }else {
                y=y^num;
            }
        }
        return new int[] {x,y};
    }
}