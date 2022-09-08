package com.chenghaixiang.jianzhi1.day20;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office16 {
}
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
class Solution01 {
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        long b=n;
        double res=1.0;
        //指数为负数情况
        if(b<0){
            x=1/x;
            b=-b;
        }
        while (b>0){
            if(b%2==1){
                res=res*x;
            }
            x=x*x;
            b>>=1;
        }
        return res;
    }
}