package com.chenghaixiang.jianzhi1.day21;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office15 {
}
//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
class Solution {
    //根据 与运算 定义，设二进制数字 nnn ，则有：
    //    若 n&1=0 ，则 n 二进制 最右一位 为 0 ；
    //    若 n&1=1，则 n 二进制 最右一位 为 1 。
    public int hammingWeight(int n) {
        int sum=0;
        while (n!=0){
            if((n&1)==1){
                sum=sum+1;
            }
            //n >>= 1 ： 将二进制数字 n 无符号右移一位（ Java 中无符号右移为 ">>>" ） 。
            n>>>=1;
        }
        return sum;
    }
}