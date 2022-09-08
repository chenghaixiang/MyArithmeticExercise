package com.chenghaixiang.jianzhi2.day15;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office046 {
}
//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//即取每一层的最后一个元素
class Solution02 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null){
            //队列存储每一层的结点
            //初始化添加根结点
            queue.add(root);
        }
        List<Integer> res=new LinkedList<>();

        while (!queue.isEmpty()){
            //获取当前层中结点个数
            int lg=queue.size();
            //遍历队列
            for(int i=0;i<lg;i++){
                TreeNode q=queue.poll();
                //取每一层的最后一个结点
                if(i==lg-1){
                    res.add(q.val);
                }
                if(q.left!=null){
                    queue.add(q.left);
                }
                if(q.right!=null){
                    queue.add(q.right);
                }
            }
        }
        return res;
    }
}