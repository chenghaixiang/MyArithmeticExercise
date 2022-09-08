package com.chenghaixiang.jianzhi1.day06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office32_2 {
    public static void main(String[] args) {
        TreeNode02 treeNode02=new TreeNode02(3);
        treeNode02.left=new TreeNode02(9);
        treeNode02.right=new TreeNode02(15);
        Solution02 solution02=new Solution02();
        solution02.levelOrder(treeNode02);

    }
}
class TreeNode02 {
    int val;
    TreeNode02 left;
    TreeNode02 right;
    TreeNode02(int x) { val = x; }
}
class Solution02{
    public List<List<Integer>> levelOrder(TreeNode02 root) {
        //定义一个队列
        Queue<TreeNode02> queue=new LinkedList<>();
        //定义一个链表，里面元素时一个链表，作为返回值
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null){
            //将根结点添加进队列
            queue.add(root);
        }
        while (!queue.isEmpty()){
            //因为题目要求分层输出,即[[3],[9,20],[15,7]]，则定义一个链表用于存储每一层的结点值
            List<Integer> temp=new ArrayList<>();
            //循环队列，每次队列都会加入二叉树一层结点，之后删除，直到结点为空，队列当然也为空
            //犯了错，for循环不能写成for(int i=0;i<queue.size();i++)因为在执行添加结点进队列的操作时队列的大小动态改变了，比如在执行根结点遍历时，按理说应该是执行一次循环
            //但因为添加操作后队列的大小变为2会再循环一次
            for (int i=queue.size() ; i>0; i--) {
                //将队列的对头删除并且传给一个新的TreeNode
                TreeNode02 node02=queue.poll();
                temp.add(node02.val);
                //将当前结点的左结点添加进队列
                if (node02.left!=null){
                    queue.add(node02.left);
                }
                //将当前结点的右结点添加进队列
                if (node02.right!=null) {
                    queue.add(node02.right);
                }
            }
            //将二叉树这一层结点添加temp链表，再添加进res，res在最后会是多个链表的集合
            res.add(temp);
        }
        return res;
    }
}