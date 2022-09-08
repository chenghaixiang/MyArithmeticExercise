package com.chenghaixiang.jianzhi2.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office031 {
}
class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node=cache.get(key);
        if(node==null){
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    void moveToHead(DLinkedNode node){
        removeNode(node);
        addTohead(node);
    }

    void removeNode(DLinkedNode node){
        //将当前结点的前一个结点next变成当前结点的next
        node.prev.next=node.next;
        //将当前结点下一个结点的prev变成当前结点prev
        node.next.prev = node.prev;
        //即在链表中删除当前结点
    }

    void addTohead(DLinkedNode node){
        //将当前结点添加进头结点之后
        node.prev = head;
        node.next = head.next;
        //将当前结点添加进头结点之后结点的前面
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        DLinkedNode node=cache.get(key);
        if(node==null){
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addTohead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }else {
            // // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value=value;
            moveToHead(node);
        }
    }

    DLinkedNode removeTail(){
        DLinkedNode res=tail.prev;
        removeNode(res);
        return res;
    }
}