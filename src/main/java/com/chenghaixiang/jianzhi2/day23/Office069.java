package com.chenghaixiang.jianzhi2.day23;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office069 {
}
//符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
//
//    arr.length >= 3
//    存在 i（0 < i < arr.length - 1）使得：
//        arr[0] < arr[1] < ... arr[i-1] < arr[i]
//        arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//
//给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。

class Solution02 {
    //二分查找
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        //left=1,right=n-2因为题目给的数组是大于等于3的山峰数组，用left=0,right=n-1也可以
        int left=1,right=n-2;
        int res=0;
        while (left<=right){
            int mid=(right+left)/2;
            //arr[mid]>arr[mid+1]证明目标值在左侧
            if(arr[mid]>arr[mid+1]){
                res=mid;
                right=mid-1;
            }else {
                //证明目标值在右侧
                left=mid+1;
            }
        }
        return res;
    }
}