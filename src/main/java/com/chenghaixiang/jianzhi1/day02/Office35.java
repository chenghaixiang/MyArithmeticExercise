package com.chenghaixiang.jianzhi1.day02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office35 {
    public static void main(String[] args) {
        Node head=null;
        //使用尾插法插入结点,时间复杂度有点高
        for(int i=0;i<6;i++){
            Node listNode=new  Node(i);
            //判断头结点是否为空,是的话将一个节点对象赋给它，成为头节点
            if(head==null){
                head=listNode;
            }else {
                Node cur=head;
                //从头节点开始遍历链表，将新节点挂载到最后一个节点上
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next=listNode;
                cur.next.random=cur;
            }
        }

        Solution02 solution02=new Solution02();
        Node node=solution02.copyRandomList(head);
        while (node!=null){
            //输出该结点的值和该结点指向结点的值
            if(node.random!=null) {
                System.out.println("结点的值："+node.val + " " + "结点的random指针"+node.random.val);
            }
            node=node.next;
        }
    }
}
class Node{
    int val;
    Node next;
    //random是一个指向其他结点的指针
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution02 {
    //这个算法的复制原理就是利用hashmap的key和value的映射关系，完成复制
    //先创建一个结点，将一个结点的val给它，然后利用hashmap创建映射关系
    //再将链表的的指向给复制链表
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur=head;
        //利用hashmap的键值对的映射关系完成原链表与复制链表的映射关系
        Map<Node,Node> map=new HashMap<>();
        while (cur!=null){
            //创建映射关系
            map.put(cur,new Node((cur.val)));
            cur=cur.next;
        }
        //重新指向头结点
        cur=head;
        while (cur!=null){
            //将原链表的下一个结点指向赋值给赋值链表,map.get(key)是根据传入的key值取出相应的value值
            map.get(cur).next=map.get(cur.next);
            //将原链表的random赋值给复制链表
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        //返回复制链表的头结点
        return map.get(head);
    }
}
