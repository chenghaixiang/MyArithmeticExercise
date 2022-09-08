package com.chenghaixiang.jianzhi2.day06;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office20 {
}
//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
//
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
class Solution02 {
    //遍历字符串，对每个字符，都看作回文的中心，向两端延申进行判断直到非回文。
    //回文的中心可能是一个字符，也可能是两个字符。
    //注意双指针可能越界。
    public int countSubstrings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int count=0;
        ////字符串的每个字符都作为回文中心进行判断，中心是一个字符或两个字符
        for(int i=0;i<s.length();++i){
            //一个字符
            count+=countPanduan(s,i,i);
            //两个字符
            count+=countPanduan(s,i,i+1);
        }
        return count;
    }
    // //从字符串的第start位置向左，end位置向右，比较是否为回文并计数
    int countPanduan(String s,int start,int end){
        int count=0;
        while (start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            count++;
            start--;
            end++;
        }
        return count;
    }
}