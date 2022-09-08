package com.chenghaixiang.jianzhi1.day24;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office57 {
}
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

class Solution01 {
    //滑动窗口,双指针
    public int[][] findContinuousSequence(int target) {
        int i=1,j=2,s=3;
        List<int[]> res=new ArrayList<>();
        while (i<j){
            if(s==target){
                int[] ans=new int[j-i+1];
                for(int k=i;k<=j;k++){
                    ans[k-i]=k;
                }
                res.add(ans);
            }
            if(s>=target){
                s-=j;
                i++;
            }else {
                j++;
                s+=j;
            }
        }
        return res.toArray(new int[0][]);
    }
}