package com.chenghaixiang.jianzhi1.day15;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office34 {
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//叶子节点 是指没有子节点的节点
class Solution {
    LinkedList<List<Integer>> res =new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root,sum);
        return res;
    }
    void recur(TreeNode root,int tar){
        if(root==null){
            return;
        }
        path.add(root.val);
        tar=tar-root.val;
        if (tar==0&&root.left==null&&root.right==null){
            res.add(new LinkedList(path));
        }
        recur(root.left,tar);
        recur(root.right,tar);
        //细节
        path.removeLast();
    }

}