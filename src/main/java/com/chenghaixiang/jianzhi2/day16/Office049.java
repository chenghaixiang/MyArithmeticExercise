package com.chenghaixiang.jianzhi2.day16;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office049 {
}
//给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
//
//每条从根节点到叶节点的路径都代表一个数字：
//
//    例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
//
//计算从根节点到叶节点生成的 所有数字之和 。
//
//叶节点 是指没有子节点的节点。
//输入：root = [4,9,0,5,1]
//        输出：1026
//        解释：
//        从根到叶子节点路径 4->9->5 代表数字 495
//        从根到叶子节点路径 4->9->1 代表数字 491
//        从根到叶子节点路径 4->0 代表数字 40
//        因此，数字总和 = 495 + 491 + 40 = 1026

class Solution01 {
    //深度优先搜索
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    int dfs(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        sum=sum*10+ root.val;
        if(root.right==null&&root.left==null){
            return sum;
        }else {
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }
}