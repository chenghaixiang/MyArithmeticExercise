package com.chenghaixiang.jianzhi2.day04;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office013 {
}
//给定一个二维矩阵 matrix，以下类型的多个请求：
//    计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
//实现 NumMatrix 类：
//    NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
//    int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
class NumMatrix {
    //使用前缀和方法
    //开辟一个存储前缀和的数组
    int[][] sums;
    public NumMatrix(int[][] matrix) {
        int m=matrix.length;
        if(m>0){
            int n=matrix[0].length;
            //将 sums 的列数设为 n+1 的目的是为了方便计算每一行的子数组和，
            //不需要对 col1=0 的情况特殊处理。
            //每个元素存储matrix数组从0下标到i的前缀和
            sums=new int[m][n+1];
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    sums[i][j+1]=sums[i][j]+matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int i=row1;i<=row2;i++){
            sum+=sums[i][col2+1]-sums[i][col1];
        }
        return sum;
    }
}