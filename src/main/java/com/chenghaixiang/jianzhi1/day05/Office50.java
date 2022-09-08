package com.chenghaixiang.jianzhi1.day05;

import java.util.HashMap;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office50 {
    public static void main(String[] args) {
        String s="dqqgfhwqqed";
        Solution02 solution02=new Solution02();
        System.out.println(solution02.firstUniqChar(s));

    }
}
class Solution02{
    public char firstUniqChar(String s) {
        //构建一个哈希表，如果一个字符的个数>=1,key的值置为false,否则为true
        HashMap<Character,Boolean> map=new HashMap<>();
        //将字符串转换成字符数组
        char[] total=s.toCharArray();
        for (int i=0;i<total.length;i++){
            //containsKey(key) ，map中包含指定key返回true
            map.put(total[i],!map.containsKey(total[i]));
        }
        for (int i=0;i<total.length;i++){
            //如果key对应的value为true返回key值，退出循环
            if(map.get(total[i])){
                return total[i];
            }
        }
        return ' ';
    }
}