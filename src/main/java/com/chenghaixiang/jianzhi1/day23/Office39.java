package com.chenghaixiang.jianzhi1.day23;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office39 {
    public static void main(String[] args) {
        int[] a={1, 2, 3, 2, 2, 2, 5, 4, 2};
        Solution solution=new Solution();
        solution.majorityElement(a);
    }
}
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字(有摩尔投票法，众数法，哈希法，摩尔投票法为最优解)
//摩尔投票法原理是不同的相抵消留在最后的的就是众数
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) {
                x = num;
            }
            votes =votes+((num == x) ? 1 : -1);
        }
        return x;
    }
}