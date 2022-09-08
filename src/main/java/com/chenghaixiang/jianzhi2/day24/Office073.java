package com.chenghaixiang.jianzhi2.day24;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office073 {
    public static void main(String[] args) {
        int[] a={3,6,7,11};
        Solution solution=new Solution();
        solution.getTime(a,8);
    }
}
//狒狒喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
//
//狒狒可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。
//
//狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//
//返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        //获取香蕉堆中的最大香蕉树
        for(int pile:piles){
            high=Math.max(high,pile);
        }
        //k存储h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
        int k=high;
        while (low<high){
            //low~hight这个区间表示k的范围
            int speed=(low+high)/2;
            long time=getTime(piles,speed);
            if (time<=h){
                k=speed;
                high=speed;
            }else {
                low=speed+1;
            }
        }
        return k;
    }

    //查看以当前最小吃掉香蕉速度，要多少时间
    long getTime(int[] piles,int speed){
        long time=0;
        for(int pile:piles){
            if(pile<=speed){
                time++;
                continue;
            }
            int curtime=pile/speed;
            if(pile%speed!=0){
                curtime++;
            }
            time+=curtime;
        }
        return time;
    }
}