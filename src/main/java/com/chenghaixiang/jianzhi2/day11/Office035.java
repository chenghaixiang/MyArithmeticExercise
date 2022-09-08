package com.chenghaixiang.jianzhi2.day11;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office035 {
}
//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
class Solution02 {
    public int findMinDifference(List<String> timePoints) {
        //排序
        Collections.sort(timePoints);
        int res=Integer.MAX_VALUE;
        int toMinutes=getMinutes(timePoints.get(0));
        int preMinutes=toMinutes;
        for (int i=1;i<timePoints.size();i++){
            int minutes=getMinutes(timePoints.get(i));
            // 相邻时间的时间差
            res=Math.min(res,minutes-preMinutes);
            preMinutes=minutes;
        }
        // 首尾时间的时间差
        res=Math.min(res,toMinutes+1440-preMinutes);
        return res;
    }
    //将时间字符串变成数字
    int getMinutes(String t){
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}