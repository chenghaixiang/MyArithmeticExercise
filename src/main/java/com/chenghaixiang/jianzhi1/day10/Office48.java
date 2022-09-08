package com.chenghaixiang.jianzhi1.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office48 {
    public static void main(String[] args) {
        String s="abcaacbb";
        Solution01 solution01=new Solution01();
        solution01.lengthOfLongestSubstring(s);
    }
}
//最长不含重复字符的子字符串
class Solution01{
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dic=new HashMap<>();
        int res=0,tmp=0;
        for(int j=0;j<s.length();j++){
            //获取当前字符在map集合中value（value是字符在字符串出现的最后一次位置，），没有key，就默认为-1
            int i=dic.getOrDefault(s.charAt(j),-1);
            //将字符添加到map集合中，因为map不能有相同key所以也是更新当前字符的位置
            dic.put(s.charAt(j),j);
            //当前字符的位置与自己上个相同字符的位置相减（没有相同字符的位置默认为-1）看是否大于tmp
            tmp=tmp<j-i?tmp+1:j-i;
            //存储不重复字符串长度
            res = Math.max(res,tmp);
        }
        return res;
    }
}
