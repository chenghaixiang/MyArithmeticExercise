package com.chenghaixiang.jianzhi2.day02;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office006 {
}
//给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
//函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
//假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
class Solution02 {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null||numbers.length==0){
            return new int[0];
        }
        for (int i=0;i<numbers.length;i++){
            int x=numbers[i];
            int index=binarySearc(numbers,i+1,numbers.length-1,target-x);
            if(index!=-1){
                return new int[]{i,index};
            }
        }
        return new int[0];
    }
   int binarySearc(int[] numbers,int left,int right,int target){
        while (left<=right){
            int mid=(left+right)/2;
            if(numbers[mid]==target){
                return mid;
            }
            if(numbers[mid]>target){
                right=mid-1;
            }else {
                left = mid + 1;
            }
        }
       return -1;
   }
}