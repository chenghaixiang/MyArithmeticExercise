package com.chenghaixiang.jianzhi1.day04;

import java.util.HashSet;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office03 {
    public static void main(String[] args) {
        int[] num={2, 3, 1, 0, 2, 5, 3};
        Solution solution=new Solution();
        System.out.println(solution.findRepeatNumber(num));
    }
}
class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> map=new HashSet();
        int a=-1;
        for (int i = 0; i < nums.length; i++) {
            //利用Hashset集合中不能添加相同元素的特点来判断数组中是否有相同元素
            if(!map.add(nums[i])){
               a=nums[i];
               break;
            }
        }
        return a;
    }
}
