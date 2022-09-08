package com.chenghaixiang.jianzhi2.day16;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office047 {
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
//给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
//
//节点 node 的子树为 node 本身，以及所有 node 的后代。
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        //结点值为0，并且没有子树的结点删除
        if(root.right==null&&root.left==null&&root.val==0){
            return null;
        }
        return root;
    }
}