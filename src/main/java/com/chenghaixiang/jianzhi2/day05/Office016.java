package com.chenghaixiang.jianzhi2.day05;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office016 {
    public static void main(String[] args) {
        String s="abcabcbb";
        Solution02 solution02=new Solution02();
        solution02.lengthOfLongestSubstring(s);
    }
}
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
class Solution02 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ=new HashSet<>();
        int n=s.length();
        if(n==0){
            return 0;
        }
        int rek=-1,res=0;
        for(int i=0;i<n;++i){
            if(i!=0){
                occ.remove(s.charAt(i-1));
            }
            while (rek+1<n&&!occ.contains(s.charAt(rek+1))){
                occ.add(s.charAt(rek+1));
                ++rek;
            }
            res=Math.max(res,rek-i+1);
        }
        return res;
    }
}