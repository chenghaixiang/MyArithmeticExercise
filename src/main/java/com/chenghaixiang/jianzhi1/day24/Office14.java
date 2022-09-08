package com.chenghaixiang.jianzhi1.day24;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office14 {
}
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//方法1：数学推论(将绳子剪成等长的长度为3的乘积最大，其次是2
//方法2动态规划（没看懂）之后在看
class Solution {
    public int cuttingRope(int n) {
        if(n<=3){
            return n-1;
        }
        int a=n/3;
        int b=n%3;
        if(b==0){
            return (int)Math.pow(3,a);
        }
        if(b==1){
            return (int)Math.pow(3,a-1)*4;
        }
        return (int)Math.pow(3,a)*2;
    }
}