package com.chenghaixiang.jianzhi2.day20;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office059 {
}
//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
//
//请实现 KthLargest 类：
//
//    KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
//    int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。

class KthLargest {
    //PriorityQueue是优先队列，作用是保证每次取出的元素都是队列中权值最小的，这里涉及到了大小关系，
    //元素大小的评判可以通过元素自身的自然顺序（使用默认的比较器），也可以通过构造时传入的比较器。
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        queue=new PriorityQueue<>();
        for (int x:nums){
            add(x);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if(queue.size()>k){
            //检索并删除队头
            queue.poll();
        }
        //检索不删除
        return queue.peek();
    }
}