package com.chenghaixiang.jianzhi1.day21;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office65 {
}
//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
//使用异或和位运算
class Solution01{
    public int add(int a, int b) {
        while(b!=0){
            int tempSum=a^b;
            int bSum=(a&b)<<1;
            a=tempSum;
            b=bSum;
        }
        return a;
    }
}