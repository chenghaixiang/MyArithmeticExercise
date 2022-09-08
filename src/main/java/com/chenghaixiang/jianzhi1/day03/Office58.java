package com.chenghaixiang.jianzhi1.day03;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office58 {
    public static void main(String[] args) {
        String a="abcdefg";
        Solution01 solution01=new Solution01();
        System.out.println(solution01.reverseLeftWords(a,2));
    }
}
class Solution01 {
//    public String reverseLeftWords(String s, int n) {
//        return s.substring(n, s.length()) + s.substring(0, n);
//    }

    //不允许使用切片函数时使用这个代码
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for(int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
