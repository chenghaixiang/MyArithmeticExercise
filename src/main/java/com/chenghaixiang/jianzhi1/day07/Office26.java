package com.chenghaixiang.jianzhi1.day07;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office26 {
    public static void main(String[] args) {
        TreeNode treeNodeA1=new TreeNode(3);
        treeNodeA1.left=new TreeNode(4);
        treeNodeA1.right=new TreeNode(5);
        treeNodeA1.left.left=new TreeNode(1);
        treeNodeA1.left.right=new TreeNode(2);
        TreeNode treeNodeB=new TreeNode(4);
        treeNodeB.left=new TreeNode(1);
        Solution solution=new Solution();
        System.out.println(solution.isSubStructure(treeNodeA1,treeNodeB));

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
 //时间复杂度为O(MN),空间复杂度O(M)
//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//B是A的子结构， 即 A中有出现和B相同的结构和节点值。
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //递归调用isSubStructure函数，遍历A树的结点，然后看A树是否包含B树
        //recur（）函数是看以当前结点为根节点看B是否与A相等
        return (A!=null&&B!=null)&&(recur(A,B)|| isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }
    boolean recur(TreeNode A,TreeNode B){
        //当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），提前返回,否则会进入下面语句,导致结果不正确
        if(B==null){
            return true;
        }
        //A==null，如果上面语句不成立执行到这证明B树还有结点，而A树没有，当然A当前结构不包含B树
        if (A==null||A.val!= B.val){
            return false;
        }
        //递归，先看根节点是否相同，遍历A，B的左右节点
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }
}