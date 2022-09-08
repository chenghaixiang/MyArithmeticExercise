package com.chenghaixiang.jianzhi2.day01;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office003 {
}
//给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
//Brian Kernighan 算法
//Brian Kernighan算法的原理是：对于任意整数 x，令 x=x & (x−1)，该运算将x的二进制表示的最后一个 1 变成0。
//因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
class Solution02 {
    public int[] countBits(int n) {
        int[] bits=new int[n+1];
        for(int i=0;i<=n;i++){
            bits[i]=countOne(i);
        }
        return bits;
    }
    int countOne(int x){
        int one=0;
        while (x>0){
            x=x&(x-1);
            one++;
        }
        return one;
    }
}