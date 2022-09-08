package com.chenghaixiang.jianzhi2.day18;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office53 {
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
//
//节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。

//中序遍历是左子树->根节点->右子树
//中序后继简单来说就是中序遍历中当前结点p的后一个结点，如一个中序遍历是1,2,3，结点p是2，这中序后继为3
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res=null;
        //利用二叉搜索树的特点：左子树比根节点和右子树小
        //节点p的中心后继一定比p大
        while (root!=null){
            //根节点大于P的val，则找它的左子树，一直顺延找下去，才能找到第一个大于P->val的节点，并更新节点
            if(root.val>p.val){
                res=root;
                root=root.left;
            }else {
                root=root.right;
            }
        }
        return res;
    }
}