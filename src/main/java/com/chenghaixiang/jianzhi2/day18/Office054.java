package com.chenghaixiang.jianzhi2.day18;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office054 {
}
//给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
//
//
//
//提醒一下，二叉搜索树满足下列约束条件：
//
//    节点的左子树仅包含键 小于 节点键的节点。
//    节点的右子树仅包含键 大于 节点键的节点。
//    左右子树也必须是二叉搜索树。

class Solution02 {
    int sum=0;
    //反向中序遍历，累加各个节点的值，这样得出来的数必定是二次搜索树
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            sum+= root.val;
            root.val=sum;
            convertBST(root.left);
        }
        return root;
    }
}