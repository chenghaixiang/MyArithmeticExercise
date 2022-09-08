package com.chenghaixiang.jianzhi1.day07;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office27 {
    public static void main(String[] args) {

    }
}
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
class TreeNode02 {
    int val;
    TreeNode02 left;
    TreeNode02 right;
    TreeNode02(int x) { val = x; }
 }
class Solution02 {
    public TreeNode02 mirrorTree(TreeNode02 root) {
        if(root ==null) return null;
        TreeNode02 temp=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(temp);
        return root;
    }
}