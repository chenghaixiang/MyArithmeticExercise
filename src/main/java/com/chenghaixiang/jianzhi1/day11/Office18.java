package com.chenghaixiang.jianzhi1.day11;


/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office18 {
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//返回删除后的链表的头节点。
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            return head.next;
        }
        //中间变量，存储值相等时的结点
        ListNode tem=head;
        ListNode cur=head.next;
        while (cur!=null&&cur.val!=val){
            tem=cur;
            cur=cur.next;
        }
        if(cur!=null){
            tem.next=cur.next;
        }
        return head;
    }
}