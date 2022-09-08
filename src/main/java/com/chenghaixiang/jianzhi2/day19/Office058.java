package com.chenghaixiang.jianzhi2.day19;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office058 {
    public static void main(String[] args) {
        MyCalendar myCalendar=new MyCalendar();
        myCalendar.book(10,20);
        myCalendar.book(15,25);
        myCalendar.book(20,30);
    }
}
//请实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
//
//MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
//
//当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
//
//每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
//
//请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
class MyCalendar {
    TreeSet<int[]> booked;

    public MyCalendar() {
       booked=new TreeSet<>((a,b)->a[0]-b[0]);
    }

    public boolean book(int start, int end) {
       if(booked.isEmpty()){
           booked.add(new int[]{start,end});
           return true;
       }
       int[] tmp={end,0};
       int[] arr=booked.ceiling(tmp);

       if(arr==booked.first()||booked.lower(tmp)[1]<=start) {
           booked.add(new int[]{start, end});
           return true;
       }
       return false;
    }


}