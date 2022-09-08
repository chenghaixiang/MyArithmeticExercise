package com.chenghaixiang.jianzhi1.day10;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office46 {
    public static void main(String[] args) {
        String s="21";
        System.out.println(s.compareTo("10"));
        int a='5';
        int b='0';
        int c='1';
        System.out.println(a+" "+b+" "+c);
    }
}
//把数字翻译成字符串,本质上是一个斐波那契数列，但sum判断那一块没看懂
class Solution {
    public int translateNum(int num) {
        String s=String.valueOf(num);
        int a=1,b=1;
        for (int i=2;i<=s.length();i++){
            String tmp=s.substring(i-2,i);
            int sum=tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0?a+b:a;
            b=a;
            a=sum;
        }
        return a;
    }
}
