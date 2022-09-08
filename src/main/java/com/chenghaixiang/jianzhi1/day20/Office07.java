package com.chenghaixiang.jianzhi1.day20;

import java.util.HashMap;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office07 {
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
class Solution {
    int[] preorder;
    HashMap<Integer,Integer> dic=new HashMap<>();
    //前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
    //中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。
    //原理就是利用前序遍历找出根节点，利用中序遍历划分左右子树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        for (int i=0;i<inorder.length;i++){
            dic.put(inorder[i],i);
        }
        return recur(0, 0, inorder.length - 1);
    }
    //root指当前结点在前序遍历数组的索引
    TreeNode recur(int root,int left,int right){
        //left是以当前根结点中序遍历划分的左边界在中序遍历数组中当前索引，
        if(left>right){
            return null;
        }
        TreeNode node=new TreeNode(preorder[root]);
        //从中序遍历数组中对应元素对应的索引，即当前结点的索引为界在中序遍历数组中前面为左子树，后面为右子树
        int i=dic.get(preorder[root]);
        node.left=recur(root+1,left,i-1);
        //i - left + root + 1含义为 根节点索引 + 左子树长度 + 1(i-left为左子树长度)
        node.right=recur(root+i-left+1,i+1,right);
        return node;
    }
}