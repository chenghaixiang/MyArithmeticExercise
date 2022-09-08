package com.chenghaixiang.jianzhi2.day21;


/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office062 {
}
//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
//
//请你实现 Trie 类：
//
//    Trie() 初始化前缀树对象。
//    void insert(String word) 向前缀树中插入字符串 word 。
//    boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
//    boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
//Trie 是一颗多叉树模型，即每个结点的分支数量可能为多个。前缀树
class Trie {
    //根节点
    TreeNode root;
    class TreeNode{
        //26个字节点，表示26个小写字母
        TreeNode[] childnext;
        //表示这个节点是否为最后一个字符
        boolean isEnd;
        TreeNode() {
            isEnd=false;
            childnext=new TreeNode[26];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root=new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        //从根节点开始遍历
        TreeNode cur=root;
        for (char ch:word.toCharArray()){
            //如果当前子结点为null，开辟子结点的子结点,相当于插入这个字符
            if(cur.childnext[ch-'a']==null){
                cur.childnext[ch-'a']=new TreeNode();
            }
            //继续插入下一个节点
            cur=cur.childnext[ch-'a'];
        }
        // 将最后一个字符设置为结尾
        cur.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cur=root;
        for (char ch:word.toCharArray()){
            //对应结点为空证明没有这个字符，直接返回false
            if(cur.childnext[ch-'a']==null){
                return false;
            }
            cur=cur.childnext[ch-'a'];
        }
        // 检查最后一个字符是否是结尾
        //比如前缀树插入了apple，传入参数是app，在for循环时if条件都不满足，但在cur.isEnd时因为当前值是false，所以返回false
        return cur.isEnd;
    }

    // 查找前缀
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur=root;
        for(char ch:prefix.toCharArray()){
            if(cur.childnext[ch-'a']==null){
                return false;
            }
            cur=cur.childnext[ch-'a'];
        }
        return true;
    }

}