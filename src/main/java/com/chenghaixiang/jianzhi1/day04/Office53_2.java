package com.chenghaixiang.jianzhi1.day04;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office53_2 {
    public static void main(String[] args) {
        int[] a={0,1,2,3,4,5,6,7,8,9};
        Solution02 solution02=new Solution02();
        System.out.println(solution02.missingNumber(a));
    }
}
class Solution02 {
    public int missingNumber(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while (i<=j){
            int m=(i+j)/2;
            if (nums[m]==m){
                i=m+1;
            }else{
                j=m-1;
            }
        }
        return i;
    }
}