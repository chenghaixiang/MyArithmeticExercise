package com.chenghaixiang.jianzhi2.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office015 {
}
//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
//变位词 指字母相同，但排列不同的字符串。
class Solution01 {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        if(n<m){
            return new ArrayList<>();
        }
        List<Integer> res=new ArrayList<>();
        int[] cont1=new int[26];
        int[] cont2=new int[26];
        for(int i=0;i<m;i++){
            ++cont1[s.charAt(i)-'a'];
            ++cont2[p.charAt(i)-'a'];
        }
        if(Arrays.equals(cont1,cont2)){
            res.add(0);
        }
        for(int i=m;i<n;i++){
            --cont1[s.charAt(i-m)-'a'];
            ++cont1[s.charAt(i)-'a'];
            if(Arrays.equals(cont1,cont2)){
                res.add(i-m+1);
            }
        }
        return res;
    }
}