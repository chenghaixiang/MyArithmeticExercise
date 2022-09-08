package com.chenghaixiang.jianzhi2.day07;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office022 {
}
//给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
//说明：不允许修改给定的链表。
class ListNode01 {
    int val;
    ListNode01 next;

    ListNode01(int x) {
        val = x;
        next = null;
    }
}
class Solution01 {
    //使用双指针，快慢指针
    public ListNode01 detectCycle(ListNode01 head) {
        ListNode01 fast=head,slow=head;
        while (true){
            if(fast==null||fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) break;
        }
        fast=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}