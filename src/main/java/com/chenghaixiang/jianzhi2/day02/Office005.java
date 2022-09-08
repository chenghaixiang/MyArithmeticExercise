package com.chenghaixiang.jianzhi2.day02;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office005 {
}
//给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，
//它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
class Solution01 {
    public int maxProduct(String[] words) {
        int n=words.length;
        //用一个int数组表示每个元素职中单词是否出现，如一个元素是‘abcd’，那它对应的int元素bit位是0000000000000000001111
        //用26位bit位来表示26个单词是否出现
        int[] masks=new int[n];
        //预计算String[]中每元素的mask
        for(int i=0;i<n;i++){
            int bitmask=0;
            //如果单词出现在对应的bit位上变成1，具体看leetcode上解析
            for (char c:words[i].toCharArray()){
                bitmask|=(1<<(c-'a'));
            }
            masks[i]=bitmask;
        }

        int ans=0;
        for (int i=0;i<words.length;i++){
            String word1=words[i];
            for (int j=i+1;j < words.length; j++){
                String word2=words[j];
                //为什么用&,mask[]表示每个字符串对应出现单词的bit表示，如果它们不包含相同字符每一位&，则答案为0
                if((masks[i]&masks[j])==0){
                    ans=Math.max(ans,word1.length()*word2.length());
                }
            }
        }
        return ans;
    }
}