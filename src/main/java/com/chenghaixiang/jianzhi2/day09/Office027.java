package com.chenghaixiang.jianzhi2.day09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office027 {
}
//给定一个链表的 头节点 head ，请判断其是否为回文链表。
//
//如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
//最简单方法是使用一个额外的可以访问下标的数据结构，然后复制比对
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> temp=new ArrayList<>();

        ListNode cur=head;
        while (cur!=null){
            temp.add(cur.val);
            cur=cur.next;
        }

        int zhizhen1=0;
        int zhizhen2=temp.size()-1;
        while (zhizhen1<zhizhen2){
            if(!temp.get(zhizhen1).equals(temp.get(zhizhen2))){
                return false;
            }
            zhizhen1++;
            zhizhen2--;
        }
        return true;
    }
}