package com.chenghaixiang.jianzhi1.day08;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office10 {
}
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)
//斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
class Solution{
    public int fib(int n){
        int a=0,b=1,sum;
        for (int i=0;i<n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return a%1000000007;
    }
}