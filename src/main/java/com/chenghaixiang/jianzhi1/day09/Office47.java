package com.chenghaixiang.jianzhi1.day09;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office47 {
}
class Solution01 {
    public int maxValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0&&j==0){
                    continue;
                }
                if (i==0){
                    grid[i][j]=grid[i][j-1]+grid[i][j];
                    continue;
                }
                if (j==0){
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                    continue;
                }
                else  {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
