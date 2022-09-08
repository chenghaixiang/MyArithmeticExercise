package com.chenghaixiang.jianzhi1.day02;

import java.util.Stack;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office06 {
    public static void main(String[] args) {
        ListNode head=null;
        //使用尾插法插入结点,时间复杂度有点高
        for(int i=0;i<6;i++){
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
        //注意这里不能传入头插法的链表,因为头插法的头节点是变化的，以我的理解来说它的指针指向的是屁股
        solution.reversePrint(head);
    }
}
//节点对象
 class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}

class Solution{
    //传入一个链表的头结点
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode temp=head;
        //将链表的头结点压入栈，然后指向下个结点
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int size=stack.size();
        int[] print =new int[size];
        //利用栈先进后出的特点将值一个个结点对象弹出，放入数组中，实现链表的倒序输出
        for (int i=0;i<size;i++){
            print[i]=stack.pop().val;
            System.out.print(print[i]);
        }
        return print;
    }
}