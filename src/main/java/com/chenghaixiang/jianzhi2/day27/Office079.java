package com.chenghaixiang.jianzhi2.day27;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office079 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        Solution solution=new Solution();
        solution.subsets(nums);
    }
}
//给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    //回溯法有点蒙圈，在看看
    public List<List<Integer>> subsets(int[] nums) {
        trackback(0,nums,new ArrayList<Integer>());
        return res;
    }
    public void trackback(int idex,int[] nums,List<Integer> list){
        res.add(new ArrayList<Integer>(list));
        for(int i=idex;i<nums.length;i++){
            list.add(nums[i]);
            trackback(i+1,nums,list);
            list.remove(list.size()-1);
        }
    }
}