package com.chenghaixiang.jianzhi2.day06;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office018 {
}
//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
//
//本题中，将空字符串定义为有效的 回文串 。
class Solution {
    //使用双指针
    public boolean isPalindrome(String s) {
        int n=s.length();
        int left=0,right=n-1;
        while (left<right){
            //Character.isLetterOrDigit()确定指定的字符是字母还是数字。
            while (left<right&&!Character.isLetterOrDigit(s.charAt(left))){
                ++left;
            }
            while (left<right&&!Character.isLetterOrDigit(s.charAt(right))){
                --right;
            }
            if(left<right){
                //Character.toLowerCase将大写变成小写
                if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}