package com.chenghaixiang.jianzhi2.day11;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office034 {
    public static void main(String[] args) {
        String[] strings;
        strings= new String[]{"hello", "leetcode"};
        Solution01 solution01=new Solution01();
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        solution01.isAlienSorted(strings,order);
    }
}
//某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
//
//给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。

//题目简单解释就是比较字符串数组中，两两字符串每个位置的字符是否符合字典顺序
class Solution01 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index=new int[26];
        //将字典添加进数组
        for(int i=0;i<order.length();++i){
            //各个字符所在字符串的位置
            index[order.charAt(i)-'a']=i;
        }
        //遍历字符串数组，从第1个和第2个开始比较
        for(int i=1;i<words.length;i++){
            boolean vaild=false;
            //两个字符串其中一个到结尾就结束遍历
            for(int j=0;j<words[i-1].length()&&j<words[i].length();j++){
                //从比较的字符串中每个位置字符在字典中的位置
                int prev=index[words[i-1].charAt(j)-'a'];
                int cur=index[words[i].charAt(j)-'a'];
                //只要一个满足
                if(prev<cur){
                    vaild=true;
                    break;
                }else if(prev>cur){
                    return false;
                }
            }
            //特殊情况需要处理，设 strs[i] 的长度为 m，strs[i] 的长度小于 strs[i−1] 的长度且 strs[i−1] 的前 m个字符与 strs[i−1]的前 m 个字符相等，
            //此时 strs[i−1]的字典序大于 strs[i] 的字典序。
            if(!vaild){
                if(words[i-1].length()>words[i].length()){
                    return false;
                }
            }
        }
        return true;
    }
}