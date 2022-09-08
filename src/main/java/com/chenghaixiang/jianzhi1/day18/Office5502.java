package com.chenghaixiang.jianzhi1.day18;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office5502 {
    public static void main(String[] args) {
        TreeNode01 treeNode01=new TreeNode01(2);
        treeNode01.right=new TreeNode01(3);
        treeNode01.right.right=new TreeNode01(4);
        treeNode01.right.right.right=new TreeNode01(5);
        treeNode01.right.right.right.right=new TreeNode01(6);
        Solution01 solution01=new Solution01();
        solution01.isBalanced(treeNode01);
    }
}
class TreeNode01 {
    int val;
    TreeNode01 left;
    TreeNode01 right;
    TreeNode01(int x) { val = x; }
}
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
class Solution01 {
    //后序遍历
    public boolean isBalanced(TreeNode01 root) {
        return recur(root)!=-1;
    }
    int recur(TreeNode01 root){
        if (root==null){
            return 0;
        }
        int left=recur(root.left);
        //如果左子树不是平衡二叉树那整个树都不是
        if(left==-1){
            return -1;
        }
        int right=recur(root.right);
//        if(right==-1){
//            return -1;
//        }
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
}