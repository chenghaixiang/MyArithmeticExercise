package com.chenghaixiang.jianzhi2.day01;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Ofiice002 {
}
//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
//输入为 非空 字符串且只包含数字 1 和 0。
class Solution01 {
    //模拟进位算法
    public String addBinary(String a, String b) {
        StringBuffer res=new StringBuffer();
        //变量 carry 表示上一个位置的进位.初始为0,
        int n=Math.max(a.length(),b.length()),carry=0;
        for(int i=0;i<n;++i){
            //记两个个位为a，b，则每一位答案为(carry+a+b)mod2,下一位的进位为（carry + a+ b）/2
            //(carry+a+b)可能为0,1,2,3
            carry+=i<a.length()?(a.charAt(a.length()-1-i)-'0'):0;
            //相当于(carry+a+b)
            carry+=i<b.length()?(b.charAt(b.length()-1-i)-'0'):0;
            res.append((char)(carry%2+'0'));
            carry=carry/2;
        }
        //最后如果 carry 的最高位不为 000，则将最高位添加到计算结果的末尾。
        if(carry>0){
            res.append('1');
        }
        //反转字符串
        res.reverse();
        return res.toString();
    }
}