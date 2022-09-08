package com.chenghaixiang.jianzhi1.day12;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office52 {
}
class ListNode01{
    int val;
    ListNode01 next;
    ListNode01(int x) {
         val = x;
        next = null;
    }
}
//输入两个链表，找出它们的第一个公共节点。
//使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，
//然后同时分别逐结点遍历，当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
//这样，当它们相遇时，所指向的结点就是第一个公共结点。
class Solution01 {
    public ListNode01 getIntersectionNode(ListNode01 headA, ListNode01 headB) {
        ListNode01 A=headA;
        ListNode01 B=headB;
        //数学公式推导出来上述的结论
        while (A!=B){
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }
        return A;
    }
}