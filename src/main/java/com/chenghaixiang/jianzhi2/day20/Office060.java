package com.chenghaixiang.jianzhi2.day20;

import java.util.*;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office060 {
    public static void main(String[] args) {
        int[] a=new int[]{1,1,1,2,2,3};
        Solution solution=new Solution();
        solution.topKFrequent(a,2);
    }
}
//给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
class Solution {
    //堆
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> curr=new HashMap<>();
        for (int num:nums){
            //遍历数组统计各个数字出现的次数
            curr.put(num,curr.getOrDefault(num,0)+1);
        }

        //初始化小顶堆
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        //new Comparator<int[]>()自定义比较器,比较compare方法中自定义的比较,实现排序
        //堆顶是次数出现最小的值

        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            //返回负整数，零或正整数，第一个参数小于，等于或大于第二个参数。
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for (Map.Entry<Integer,Integer> entry:curr.entrySet()){
            int num=entry.getKey(),count=entry.getValue();
            if(queue.size()==k){
                if(queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else {
                queue.offer(new int[]{num,count});
            }
        }
        int[] res=new int[k];
        for (int i=0;i<k;++i){
            res[i]=queue.poll()[0];
        }
        return res;
    }
}