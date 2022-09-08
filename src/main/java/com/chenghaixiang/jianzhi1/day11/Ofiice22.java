package com.chenghaixiang.jianzhi1.day11;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Ofiice22 {
}
class ListNode01 {
    int val;
    ListNode01 next;

    ListNode01(int x) {
        val = x;
    }
}
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
class Solution01 {
    //使用双指针,不用遍历链表计算长度
    public ListNode01 getKthFromEnd(ListNode01 head, int k) {
        ListNode01 former=head;
        ListNode01 latter=head;
        for (int i=0;i<k;i++){
            former=former.next;
        }
        while (former!=null){
            former=former.next;
            latter=latter.next;
        }
        return latter;
    }
}