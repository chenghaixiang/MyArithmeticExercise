package com.chenghaixiang.jianzhi1.day04;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office53 {
    public static void main(String[] args) {
        int[] a={5,7,7,8,8,8,8,8,10};
        Solution01 solution01=new Solution01();
        System.out.println(solution01.search(a,8));

    }
}
class Solution01 {
    //因为题目给的是一个有序数组，这个方法时间和空间复杂多较高，换网上大佬的题解
//    public int search(int[] nums, int target) {
//        HashSet<Integer> map=new HashSet<>();
//        int i=0;
//        for(int num:nums){
//            if(num==target) {
//                if (!map.add(num)&&i!=0){
//                    i++;
//                }else {
//                    i++;
//                }
//            }
//        }
//        return i;
//    }
    public int search(int[] nums, int target) {
        return erfeng(nums,target)-erfeng(nums,target-1);
    }
    int erfeng(int nums[],int target_1){
        int i=0;
        int j=nums.length-1;
        //二分查找法，搜索右边界
        while (i<=j){
            //中点
            int m=(i+j)-1;
            //中点的值小于等于目标值，证明右边界i比中点大
            if(nums[m]<=target_1){
                i=m+1;
            }else {
                j=m-1;
            }
        }
        //返回右边界
        return i;
    }
}
