package com.chenghaixiang.jianzhi2.day07;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office023 {
}
class ListNode02 {
    int val;
    ListNode02 next;

    ListNode02(int x) {
        next = null;
    }
}
//剑指 Offer II 023. 两个链表的第一个重合节点
//给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
//与剑指Office原版为同一题
class Solution02 {
    public ListNode02 getIntersectionNode(ListNode02 headA, ListNode02 headB) {
        ListNode02 A=headA;
        ListNode02 B=headB;
        //数学公式推导出来上述的结论
        while (A!=B){
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }
        return A;
    }
}