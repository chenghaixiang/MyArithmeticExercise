package com.chenghaixiang.jianzhi1.day20;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office33 {
}
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
class Solution02 {
    //是一个二叉搜索树(左子树比根节点小，右子树比根节点大
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }
    boolean recur(int[] postorder,int i,int j){
        // 当 i≥j ，说明此子树节点数量 ≤1 ，无需判别正确性，因此直接返回 true
        if(i>=j){
            return true;
        }
        int p=i;
        while (postorder[p]<postorder[j]){
            p++;
        }
        int m=p;
        while (postorder[p]>postorder[j]){
            p++;
        }
        //p=j ： 判断 此树 是否正确。
        return p==j&&recur(postorder,i,m-1)&&recur(postorder,m,j-1);
    }
}