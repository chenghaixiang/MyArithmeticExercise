package com.chenghaixiang.jianzhi1.day15;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office54 {
}
class TreeNode01 {
     int val;
     TreeNode01 left;
     TreeNode01 right;
    TreeNode01(int x) { val = x; }
}

class Solution02 {
    int res,k;
    public int kthLargest(TreeNode01 root, int k) {
        this.k=k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode01 root){
        if(root==null){
            return;
        }
        dfs(root.right);
        if(k==0){
            return;
        }
        if(--k==0){
            res= root.val;
        }
        dfs(root.left);
    }
}