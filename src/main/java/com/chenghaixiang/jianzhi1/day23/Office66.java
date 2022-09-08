package com.chenghaixiang.jianzhi1.day23;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office66 {
}
//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
//即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
class Solution01 {
    public int[] constructArr(int[] a) {
        int len=a.length;
        if(len==0){
            return new int[0];
        }
        int[] b=new int[len];
        b[0]=1;
        for(int i=1;i<len;i++){
            b[i]=b[i-1]*a[i-1];
        }
        int temp=1;
        for(int i=len-2;i>=0;i--){
            temp=temp*a[i+1];
            b[i]=b[i]*temp;
        }
        return b;
    }
}