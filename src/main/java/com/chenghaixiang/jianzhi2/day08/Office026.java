package com.chenghaixiang.jianzhi2.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office026 {
}
//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
// L0 → L1 → … → Ln-1 → Ln
//请将其重新排列后变为：
//L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
//不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
class ListNode02 {
    int val;
    ListNode02 next;

    ListNode02() {
    }

    ListNode02(int val) {
        this.val = val;
    }

    ListNode02(int val, ListNode02 next) {
        this.val = val;
        this.next = next;
    }
}

class Solution02 {
    //使用线性表方法
    //因为线性表可以使用下标直接访问
    public void reorderList(ListNode02 head) {
        if(head==null){
            return;
        }
        List<ListNode02> list=new ArrayList<>();
        ListNode02 node=head;
        while (node!=null){
            list.add(node);
            node=node.next;
        }
        int i=0,j=list.size()-1;
        while (i<j){
            list.get(i).next=list.get(j);
            i++;
            if(i==j){
                break;
            }
            list.get(j).next=list.get(i);
            j--;
        }
        list.get(i).next=null;
    }
}