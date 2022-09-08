package com.chenghaixiang.jianzhi1.day17;

import java.util.Arrays;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office40 {
}
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//快排或者其他排序都可以
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        //利用java自带的API函数排序
//        int [] vec=new int[k];
//        Arrays.sort(arr);
//        for (int i=0;i<k;i++){
//            vec[i]=arr[i];
//        }
//        return vec;
        quickSort(arr,0,arr.length-1);
        return Arrays.copyOf(arr,k);
    }
    void quickSort(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int i=l,j=r;
        while (i<j){
            while (i<j&&arr[j]>=arr[l]){
                j--;
            }
            while (i<j&&arr[i]<=arr[l]){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,i,j);
        quickSort(arr,l,i-1);
        quickSort(arr,i+1,r);
    }
    void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}