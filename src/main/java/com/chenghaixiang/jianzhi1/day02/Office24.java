package com.chenghaixiang.jianzhi1.day02;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office24 {
    public static void main(String[] args) {
        ListNode01 head=null;
        //使用尾插法插入结点,时间复杂度有点高
        for(int i=0;i<6;i++){
            ListNode01 listNode=new ListNode01(i);
            //判断头结点是否为空,是的话将一个节点对象赋给它，成为头节点
            if(head==null){
                head=listNode;
            }else {
                ListNode01 cur=head;
                //从头节点开始遍历链表，将新节点挂载到最后一个节点上
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next=listNode;
            }
        }

        Solution01 solution01=new Solution01();
        ListNode01 listNode01=solution01.reverseList(head);
        //从头结点开始输出结点元素
        for (int i=0;i<6;i++){
            System.out.println(listNode01.val);
            listNode01=listNode01.next;
        }
    }
}
//节点对象
class ListNode01{
    int val;
    ListNode01 next;
    ListNode01(int x){
        val=x;
    }
}
//题目要求为链表的倒序输出，并且之前的头节点指向空
class Solution01 {
    public ListNode01 reverseList(ListNode01 head) {
        ListNode01 prev=null;
        ListNode01 curr=head;
        while (curr!=null){
            //存储当前结点的下个结点，为中间变量
            ListNode01 temp=curr.next;
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