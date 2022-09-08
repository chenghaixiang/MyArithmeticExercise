package com.chenghaixiang.jianzhi1.day05;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office04 {
    public static void main(String[] args) {
        int a[][] = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        Solution solution = new Solution();
        System.out.println(solution.findNumberIn2DArray(a,6595));
    }
}
//该题思路是讲一个二维数组旋转45度，这时这个二维数组看起来像一个二叉树，利用每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序的规律
//从二维数组底部的一维数组的第一个元素开始，当前元素小于目标元素就往右下移动，反之亦然。直到找到matrix[j][i]==target，否则返回false
//说怎么多，不如直接看图，LeetCode上jyd的题解
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //一维数组中的下标
        int i = 0;
        //二维数组中第几个一维数组下标
        int j = matrix.length - 1;
        while (j >= 0 && i < matrix[0].length) {
            if (matrix[j][i] > target) {
                j--;
            } else if (matrix[j][i] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}

