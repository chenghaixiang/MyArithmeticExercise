package com.chenghaixiang.jianzhi1.day16;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office61 {
}
//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
//如果为顺子排序后的最大值和最小值必定小于5
class Solution01 {
    public boolean isStraight(int[] nums) {
        //判断是否重复 HashSet
        Set<Integer> repeat=new HashSet<>();
        int max=0;
        int min=14;
        for (int num:nums){
            //跳过大小王
            if(num==0){
                continue;
            }
            max=Math.max(max,num);
            min=Math.min(min,num);
            if (repeat.contains(num)){
                return false;
            }
            repeat.add(num);
        }
        return max-min<5;
    }
}