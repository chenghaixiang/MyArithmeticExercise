package com.chenghaixiang.jianzhi2.day10;

import java.util.Arrays;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office032 {
}
//给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
//
//注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
class Solution02 {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t)){
            return false;
        }
        int[] cnt1=new int[26];
        int[] cnt2=new int[26];
        for (int i=0;i<s.length();i++){
            ++cnt1[s.charAt(i)-'a'];
        }
        for (int i=0;i<t.length();i++){
            ++cnt2[t.charAt(i)-'a'];
        }
        if(Arrays.equals(cnt1,cnt2)){
            return true;
        }else {
            return false;
        }
    }
}