package com.chenghaixiang.jianzhi1.day06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office32 {
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        //定义一个队列
        Queue<TreeNode> queue=new LinkedList<>();
        //将二叉树的根节点放入队列中
        queue.add(root);
        //创建一个链表用于接收结点的值，为什么不用数组，因为函数返回结果要数组，但数组无法动态扩容，所以用链表接收值在传给数组
        ArrayList<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            //将队列的对头删除并且传给一个新的TreeNode
            TreeNode node=queue.poll();
            //将值添加进链表
            list.add(node.val);
            //将当前结点的左结点添加进队列
            if (node.left!=null){
                queue.add(node.left);
            }
            //将当前结点的右结点添加进队列
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        int[] res=new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
