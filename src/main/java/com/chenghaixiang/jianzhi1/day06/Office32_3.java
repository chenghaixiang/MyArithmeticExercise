package com.chenghaixiang.jianzhi1.day06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office32_3 {
}
class TreeNode03 {
    int val;
    TreeNode03 left;
    TreeNode03 right;
    TreeNode03(int x) { val = x; }
}
class Solution03 {
    public List<List<Integer>> levelOrder(TreeNode03 root) {
        //定义一个队列
        Queue<TreeNode03> queue=new LinkedList<>();
        //定义一个链表，里面元素时一个链表，作为返回值
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null){
            //将根结点添加进队列
            queue.add(root);
        }
        while (!queue.isEmpty()){
            //因为题目要求分层输出,并且在偶数层从右往左，奇数层反之，则定义一个双向链表或者说双端队列用于存储每一层的结点值
            LinkedList<Integer> temp=new LinkedList<>();
            //循环队列，每次队列都会加入二叉树一层结点，之后删除，直到结点为空，队列当然也为空
            //犯了错，for循环不能写成for(int i=0;i<queue.size();i++)因为在执行添加结点进队列的操作时队列的大小动态改变了，比如在执行根结点遍历时，按理说应该是执行一次循环
            //但因为添加操作后队列的大小变为2会再循环一次
            for (int i=queue.size() ; i>0; i--) {
                //将队列的对头删除并且传给一个新的TreeNode
                TreeNode03 node03=queue.poll();
                if (res.size()%2==0){
                    temp.addLast(node03.val);
                }
                else {
                    temp.addFirst(node03.val);
                }
                //将当前结点的左结点添加进队列
                if (node03.left!=null){
                    queue.add(node03.left);
                }
                //将当前结点的右结点添加进队列
                if (node03.right!=null) {
                    queue.add(node03.right);
                }
            }
            //将二叉树这一层结点添加temp链表，再添加进res，res在最后会是多个链表的集合
            res.add(temp);
        }
        return res;
    }
}