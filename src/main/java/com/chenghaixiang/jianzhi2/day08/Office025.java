package com.chenghaixiang.jianzhi2.day08;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office025 {
}
class ListNode01 {
    int val;
    ListNode01 next;

    ListNode01() {
    }

    ListNode01(int val) {
        this.val = val;
    }

    ListNode01(int val, ListNode01 next) {
        this.val = val;
        this.next = next;
    }
}
//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
//可以假设除了数字 0 之外，这两个数字都不会以零开头。
class Solution01 {
    public ListNode01 addTwoNumbers(ListNode01 l1, ListNode01 l2){
        Deque<Integer> stack1=new ArrayDeque<>();
        Deque<Integer> stack2=new ArrayDeque<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode01 res=null;
        while (!stack1.isEmpty()||!stack2.isEmpty()||carry!=0){
            int a=stack1.isEmpty()?0:stack1.pop();
            int b=stack2.isEmpty()?0:stack2.pop();
            //进位模拟
            int cur=a+b+carry;
            //看是否进1
            carry=cur/10;
            //进位上的余数
            cur=cur%10;
            ListNode01 curnode=new ListNode01(cur);
            curnode.next=res;
            res=curnode;
        }
        return res;
    }
}