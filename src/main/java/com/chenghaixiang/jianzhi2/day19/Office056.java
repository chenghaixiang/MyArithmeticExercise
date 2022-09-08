package com.chenghaixiang.jianzhi2.day19;

import com.sun.source.tree.UsesTree;

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office056 {
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
//给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
class Solution {
    //存储结点值
    Set<Integer> map =new HashSet<>();
    //方法一：深度优先搜索 + 哈希表
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        //k-root.val存在，证明map中存在结点加上当前结点等于k
        if(map.contains(k- root.val)) {
            return true;
        }
        map.add(root.val);
        return findTarget(root.left,k)||findTarget(root.right,k);
    }
}