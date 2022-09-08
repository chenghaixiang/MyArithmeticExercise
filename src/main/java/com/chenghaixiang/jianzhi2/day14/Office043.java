package com.chenghaixiang.jianzhi2.day14;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office043 {
}
//完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。
//
//设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
//
//    CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构；
//    CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
//    CBTInserter.get_root() 将返回树的根节点。
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
class CBTInserter {
    Queue<TreeNode> candidate;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.candidate=new ArrayDeque<>();
        this.root=root;

        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
            //将没有左子树或右子树的结点添加进cand队列
            if(!(node.left!=null&&node.right!=null)){
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }
}