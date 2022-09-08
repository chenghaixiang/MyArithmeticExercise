package com.chenghaixiang.jianzhi2.day14;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office042 {
}
//写一个 RecentCounter 类来计算特定时间范围内最近的请求。
//
//请实现 RecentCounter 类：
//
//    RecentCounter() 初始化计数器，请求数为 0 。
//    int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
//保证 每次对 ping 的调用都使用比之前更大的 t 值。
class RecentCounter {
    //每次对 ping 的调用都使用比之前更大的 t 值。所以可以用队列
    Queue<Integer> queue;
    public RecentCounter() {
        queue=new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.add(t);
        //检索删除所以没有达到区间下限的值
        while (queue.peek()<t-3000){
            //检索并删除此队列的头，如果此队列为空，则返回 null
            queue.poll();
        }
        return queue.size();
    }

}