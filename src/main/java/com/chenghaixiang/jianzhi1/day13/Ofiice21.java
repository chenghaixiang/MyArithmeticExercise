package com.chenghaixiang.jianzhi1.day13;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Ofiice21 {
}
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
class Solution {
    public int[] exchange(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int tmp;
        while (i<j){
            //下面的取余判断是否为偶可以用位运算符，效率高。(i < j && (nums[i] & 1) == 1
            while (i<j&&(nums[i]%2)!=0){
                i++;
            }
            while (i<j&&(nums[j]%2==0)){
                j--;
            }
            tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        return nums;
    }
}