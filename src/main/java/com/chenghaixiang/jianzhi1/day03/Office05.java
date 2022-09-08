package com.chenghaixiang.jianzhi1.day03;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office05 {
    public static void main(String[] args) {
        String s="We are happy.";
        Solution solution=new Solution();
        String a=solution.replaceSpace(s);
        System.out.println(a);
    }
}
//class Solution {
//    public String replaceSpace(String s) {
//        String a="%20";
//        String b=s.replace(" ",a);
//        return b;
//    }
//}
class Solution {
    public String replaceSpace(String s) {
        StringBuffer res=new StringBuffer();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==' '){
                res.append("%20");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}