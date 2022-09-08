package com.chenghaixiang.jianzhi1.day16;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office45 {
}
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
class Solution {
    public String minNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i]=String.valueOf(nums[i]);
        }
        quickSort(strs,0,strs.length-1);
        StringBuffer res=new StringBuffer();
        for (String s:strs){
            res.append(s);
        }
        return res.toString();
    }

    //使用快排
    void quickSort(String[] strs,int l,int r){
        if(l>=r){
            return;
        }
        int i=l,j=r;
        String tmp=strs[i];
        while (i<j){
            while ((strs[j]+strs[l]).compareTo(strs[l]+strs[j])>=0&&i<j){
                j--;
            }
            while ((strs[i]+strs[l]).compareTo(strs[l]+strs[i])<=0&&i<j){
                i++;
            }
            tmp=strs[i];
            strs[i]=strs[j];
            strs[j]=tmp;
        }
        strs[i]=strs[l];
        strs[l]=tmp;
        quickSort(strs,l,i-1);
        quickSort(strs,i+1,r);
    }
}