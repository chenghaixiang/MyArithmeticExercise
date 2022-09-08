package com.chenghaixiang.jianzhi1.day13;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office58 {
    public static void main(String[] args) {
        String s="  hello world!  ";
        Solution02 solution02=new Solution02();
        String a=solution02.reverseWords(s);
        System.out.println(a);
    }
}
//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
class Solution02 {
    public String reverseWords(String s) {
        //删除收尾空格
        s=s.trim();
        int j=s.length()-1,i=j;
        StringBuffer res=new StringBuffer();
        while (i>=0){
            //从字符串尾部搜索，遇到第一个空格，i+1与j+1的差值就是一个单词
            while (i>=0&&s.charAt(i)!=' '){
                i--;
            }
            res.append(s.substring(i+1,j+1)+" ");
            //因为给的字符串可能两个单词之间有多个空格，所以搜索第一个遇到的字母，跳过空格
            while (i>=0&&s.charAt(i)==' '){
                i--;
            }
            j=i;
        }
        return res.toString().trim();
    }
}
