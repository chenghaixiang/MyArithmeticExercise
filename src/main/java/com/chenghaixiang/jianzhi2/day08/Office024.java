package com.chenghaixiang.jianzhi2.day08;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office024 {
}
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
//给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            //存储当前结点的下个结点，为中间变量
            ListNode temp=curr.next;
            //将当前结点的下个结点变成它的前一个结点，如果没有则为空
            curr.next=prev;
            //prev是存储当前结点，为下一次循环做准备
            prev=curr;
            //将当前结点变成下个结点，即将指向倒过来，当到链表的最后一个元素时，temp必定为null退出循环
            curr=temp;
        }
        return prev;
    }
}