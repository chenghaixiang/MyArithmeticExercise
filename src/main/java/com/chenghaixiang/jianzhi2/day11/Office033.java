package com.chenghaixiang.jianzhi2.day11;

import java.util.*;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office033 {
}
//给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
//
//注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str:strs){
            char[] chars=str.toCharArray();
            //排序
            Arrays.sort(chars);
            String key=new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());


    }
}