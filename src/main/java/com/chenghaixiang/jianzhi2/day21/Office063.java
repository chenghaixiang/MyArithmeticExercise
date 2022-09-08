package com.chenghaixiang.jianzhi2.day21;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office063 {
}
//在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
//
//现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
//
//需要输出替换之后的句子。
class Solution {
    class Trie{
        //前缀树
        Map<Character,Trie> children;
        Trie() {
            children=new HashMap<>();
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie=new Trie();
        for (String word:dictionary){
            Trie cur=trie;
            //将字典放入前缀树
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                //put在放入数据时，如果放入数据的key已经存在与Map中，最后放入的数据会覆盖之前存在的数据，
                //
                //而putIfAbsent在放入数据时，如果存在重复的key，那么putIfAbsent不会放入值。
                cur.children.putIfAbsent(c,new Trie());
                cur=cur.children.get(c);
            }
            //字典中各个单词结尾
            cur.children.put('#',new Trie());
        }

        String[] words=sentence.split(" ");
        for(int i=0;i<words.length;i++){
            words[i]=findRoot(words[i],trie);
        }
        return String.join(" ",words);
    }

    //对字符串按字典进行处理，继承词用词根替换掉
    String findRoot(String words,Trie trie){
        StringBuffer root=new StringBuffer();
        Trie cur=trie;
        for (int i=0;i<words.length();i++){
            char c=words.charAt(i);
            if(cur.children.containsKey('#')){
                return root.toString();
            }
            if (!cur.children.containsKey(c)){
                return words;
            }
            root.append(c);
            cur=cur.children.get(c);
        }
        return root.toString();
    }
}