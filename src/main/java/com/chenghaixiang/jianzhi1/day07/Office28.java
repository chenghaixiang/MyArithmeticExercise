package com.chenghaixiang.jianzhi1.day07;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office28 {
}
class TreeNode03 {
    int val;
    TreeNode03 left;
    TreeNode03 right;
    TreeNode03(int x) { val = x; }
}
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
class Solution03 {
    public boolean mirrorTree(TreeNode03 root) {
        return root==null?true:recur(root.left,root.right);
    }
    boolean recur(TreeNode03 L,TreeNode03 R){
        if(L==null&&R==null){
            return true;
        }
        if(L==null||R==null||L.val!=R.val){
            return false;
        }
        return recur(L.left,R.right)&&recur(L.right,R.left);
    }
}