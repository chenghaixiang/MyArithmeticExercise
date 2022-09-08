package com.chenghaixiang.jianzhi2.day06;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office019 {
}
//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
class Solution01 {
    public boolean validPalindrome(String s) {
        int low=0,hight=s.length()-1;
        while (low<hight){
            char c1=s.charAt(low),c2=s.charAt(hight);
            if(c1==c2){
                ++low;
                --hight;
            }else {
                return panduan(s,low,hight-1)||panduan(s,low+1,hight);
            }
        }
        return true;
    }

    boolean panduan(String s,int low,int hight){
        for (int i=low,j=hight;i<j;++i,--j){
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(c1!=c2){
                return false;
            }
        }
        return true;
    }
}