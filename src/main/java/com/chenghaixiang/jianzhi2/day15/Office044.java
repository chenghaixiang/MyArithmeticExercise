package com.chenghaixiang.jianzhi2.day15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office044 {
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
        this.left = left;
        this.right = right;
    }
}

class Solution {
    //深度优先搜索
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> res=new ArrayList<>();
        dfs(res,root,0);
        return res;

    }

    public void dfs(List<Integer> res,TreeNode root,int curHeight){
        //curheight表示的是层数
        //递归先遍历左子树，将当前层的第一个元素添加进链表
        if(curHeight==res.size()){
            res.add(root.val);
        }else {
            //curHeight在链表中表示当前层的下标
            //更新当前层中元素的最大值
            res.set(curHeight,Math.max(res.get(curHeight),root.val));
        }
        if(root.left!=null){
            //curHeight+1层数加1
            dfs(res,root.left,curHeight+1);
        }
        if(root.right!=null){
            dfs(res,root.right,curHeight+1);
        }

    }
}