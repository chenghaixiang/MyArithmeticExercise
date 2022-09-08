package com.chenghaixiang.jianzhi1.day14;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Ofiice12 {

}
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
class Solution {
    //'深度优先搜索（DFS）+ 剪枝
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board,char[] word,int i,int j,int k){
        //i>=board.length||i<0||j>= board[0].length||j<0检查下标是否越界
        if (i>=board.length||i<0||j>= board[0].length||j<0||board[i][j]!=word[k]){
            return false;
        }
        //k是字符串word长度
        if(k==word.length-1){
            return true;
        }
        //当前字符匹配，将当前字符变为‘\0’，为了让当前字符不不会被重复使用
        board[i][j]='\0';
        //递归搜索当前字符的上下左右4个方向
        boolean res=dfs(board,word,i+1,j,k+1)||dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j]=word[k];
        return res;
    }
}