package com.chenghaixiang.jianzhi2.day05;

import java.util.Arrays;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office014 {
    public static void main(String[] args) {
        String s1="ab";
        String s2="eidbaooo";
        Solution solution=new Solution();
        solution.checkInclusion(s1,s2);
    }
}
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
//
//换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
//变位词是相同单词的顺序不同,如”asd“是”ads“的变位词，即s2的子串是否与s1的单词个数相等
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        //存储s1的单词统计，s2的从0到n的单词统计，如s1是“ab”，s2是”eidbaooo“，cnt2存储的是“ei”
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        //滑动窗口，如s2是”eidbaooo“，从“ei”变成“id”，以此往复
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}