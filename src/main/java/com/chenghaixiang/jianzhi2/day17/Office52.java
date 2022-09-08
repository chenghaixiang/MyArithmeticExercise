package com.chenghaixiang.jianzhi2.day17;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office52 {
}
//给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
class Solution01 {
    public TreeNode increasingBST(TreeNode root) {
        //存放中序遍历的结果集
        List<Integer> res=new LinkedList<>();
        //中序遍历
        dfs(root,res);

        //创建一个新树
        TreeNode newtree=new TreeNode(-1);
        TreeNode currnode=newtree;
        for(int num:res){
            currnode.right=new TreeNode(num);
            currnode=currnode.right;
        }
        return newtree.right;
    }

    //中序遍历
    void dfs(TreeNode node,List<Integer> res){
        if(node==null){
            return;
        }
        dfs(node.left,res);
        res.add(node.val);
        dfs(node.right,res);
    }
}