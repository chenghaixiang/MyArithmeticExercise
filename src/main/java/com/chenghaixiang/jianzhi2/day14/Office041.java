package com.chenghaixiang.jianzhi2.day14;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office041 {
}
//给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
//
//实现 MovingAverage 类：
//
//    MovingAverage(int size) 用窗口大小 size 初始化对象。
//    double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
class MovingAverage {
    Queue<Integer> queue;
    int size;
    double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue=new ArrayDeque<>();
        this.size=size;
        sum=0;
    }
    //利用队列先进先出的特性
    public double next(int val) {
        //当当前队列大于size是证明要让窗口向后滑动，队头出列
        if(queue.size()==size){
            sum-=queue.poll();
        }
        queue.offer(val);
        sum+=val;
        return sum/queue.size();
    }

}