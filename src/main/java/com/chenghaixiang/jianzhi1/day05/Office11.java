package com.chenghaixiang.jianzhi1.day05;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office11 {
}
//使用二分查找来找到旋转点
class Solution01 {
    public int minArray(int[] numbers) {
        int i=0;
        int j=numbers.length-1;
        while (i<j){
            int m=(i+j)/2;
            if(numbers[m]>numbers[j]){
                i=m+1;
            }
            else if(numbers[m]<numbers[j]){
                j=m;
            }else if(numbers[m]==numbers[j]){
                j--;
            }
        }
        return numbers[i];
    }
}