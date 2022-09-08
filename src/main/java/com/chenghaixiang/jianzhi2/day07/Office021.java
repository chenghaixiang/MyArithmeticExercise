package com.chenghaixiang.jianzhi2.day07;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office021 {
    public static void main(String[] args) {
       ListNode head=null;
        //使用尾插法插入结点,时间复杂度有点高
        for(int i=1;i<2;i++){
            ListNode listNode=new ListNode(i);
            //判断头结点是否为空,是的话将一个节点对象赋给它，成为头节点
            if(head==null){
                head=listNode;
            }else {
               ListNode cur=head;
                //从头节点开始遍历链表，将新节点挂载到最后一个节点上
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next=listNode;
            }
        }
        Solution solution=new Solution();
        solution.removeNthFromEnd(head,1);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //为什么有这一步，注意官方给的示例2和示例3
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}