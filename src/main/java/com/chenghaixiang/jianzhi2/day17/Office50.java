package com.chenghaixiang.jianzhi2.day17;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office50 {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(-2);
        treeNode.right=new TreeNode(-3);
        Solution solution=new Solution();
        solution.pathSum(treeNode,-1);
    }
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
//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
//路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer,Integer> prefix=new HashMap<>();
        // 表示前缀和为0的节点为空，有一个空。否则若pre_i = targetSum，将错过从root到i这条路径。
        prefix.put(0,1);
        return dfs(root,prefix,0,targetSum);
    }

    int dfs(TreeNode root, Map<Integer,Integer> prefix,int curr,int targetsum){
        if(root==null){
            return 0;
        }
        int ret=0;
        //前缀和
        curr+=root.val;

        //看是否满足curr-targetsum，
        //举例：1->3->4,curr是8,targetsum是7,因为之前1的前缀和为1,8-7满足，即root到p(i)的前缀和为x,p(i+1)到p(n)的前缀和为targetsum，x+targetsum为curr
        ret=prefix.getOrDefault(curr-targetsum,0);
        //添加前缀和进去路径
        prefix.put(curr,prefix.getOrDefault(curr,0)+1);
        ret+=dfs(root.left,prefix,curr,targetsum);
        ret+=dfs(root.right,prefix,curr,targetsum);
        // 路径退缩，递归完后去掉不再在路径上的当前结点的前缀和。防止不是自己子树的结点用到这个前缀和
        prefix.put(curr,prefix.getOrDefault(curr,0)-1);

        return ret;
    }
}