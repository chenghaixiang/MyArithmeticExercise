package com.chenghaixiang.jianzhi2.day09;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office029 {
}
class Node01 {
    public int val;
    public Node01 next;

    public Node01() {}

    public Node01(int _val) {
        val = _val;
    }

    public Node01(int _val, Node01 _next) {
        val = _val;
        next = _next;
    }
};
//给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
//
//给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
//
//如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
//如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
class Solution02 {
    //简单分类讨论
    public Node01 insert(Node01 head, int insertVal) {
        Node01 node=new Node01(insertVal);
        if(head==null){
            node.next=node;
            return node;
        }
        if(head.next==head){
            head.next=node;
            node.next=head;
            return head;
        }
        Node01 cur=head,next=head.next;
        while (next!=head){
            if(insertVal>=cur.val&&insertVal<=next.val){
                break;
            }
            if(cur.val>next.val){
                if(insertVal>cur.val||insertVal<next.val){
                    break;
                }
            }
            cur=cur.next;
            next=next.next;
        }
        cur.next=node;
        node.next=next;
        return head;
    }
}