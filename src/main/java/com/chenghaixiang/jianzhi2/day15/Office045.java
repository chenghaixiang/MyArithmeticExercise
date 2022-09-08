package com.chenghaixiang.jianzhi2.day15;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office045 {
}
//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
//假设二叉树中至少有一个节点。
class Solution01 {
    int curVal = 0;
    //记录最大层数
    int curHeight = 0;

    //深度优先遍历
    public int findBottomLeftValue(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return curVal;
    }

    void dfs(TreeNode root,int height){
        if(root==null){
            return;
        }
        dfs(root.left,height+1);
        dfs(root.right,height+1);
        //当前层数大于最大层数，即当前层数是最底层，因为先遍历的左子树，所以当遍历到右子树时，如果最低层有左右子树，height==curHeight不满足条件不进入条件，所以curVal必是最底层 最左边 节点的值
        if(height>curHeight){
            curHeight=height;
            curVal=root.val;
        }

    }
}