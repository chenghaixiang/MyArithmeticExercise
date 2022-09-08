package com.chenghaixiang.jianzhi2.day02;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Oiifce004 {
}
//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
class Solution {
    //统计所有数字的各二进制位中 111 的出现次数，并对 333 求余，结果则为只出现一次的数字。
    public int singleNumber(int[] nums) {
        int[] counts=new int[32];
        for(int num:nums){
            for (int j=0;j<32;j++){
                counts[j]=counts[j]+num&1;
                //配合 无符号右移操作 ，可获取 num 所有位的值
                num>>>=1;
            }
        }
        int res=0,m=3;
        for(int i=0;i<32;i++){
            //// 左移 1 位
            res<<=1;
            // 恢复第 i 位的值到 res并且得到 只出现一次的数字 的第 (31 - i) 位
            res|=counts[31-i]%m;
        }
        return res;
    }
}