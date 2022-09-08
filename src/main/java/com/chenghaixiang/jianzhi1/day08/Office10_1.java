package com.chenghaixiang.jianzhi1.day08;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office10_1 {
}
//青蛙跳台阶
class Solution01{
    public int fib(int n){
        int a=1,b=1,sum;
        for (int i=0;i<n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return a%1000000007;
    }
}