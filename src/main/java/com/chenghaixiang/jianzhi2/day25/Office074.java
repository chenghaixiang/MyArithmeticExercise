package com.chenghaixiang.jianzhi2.day25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office074 {
    public static void main(String[] args) {

    }
}
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
//请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }

        //比较器，自定义排序规则
        //将二维数组中每个一维数组的第一个值大小排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0]-interval2[0];
            }
        });
        List<int[]> merged=new ArrayList<>();
        //循环遍历排序完数组
        for(int i=0;i<intervals.length;i++){
            //取出当前一维数组的值
            int left=intervals[i][0],right=intervals[i][1];
            //当前链表为空或者当前链表的前一个数组的最大值小于当前数组的最大值添加
            if(merged.size()==0||merged.get(merged.size()-1)[1]<left){
                merged.add(new int[]{left,right});
            }else {
                //更新
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],right);
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }
}