package com.chenghaixiang.jianzhi2.day10;

import java.util.*;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office030 {
    public static void main(String[] args) {
        RandomizedSet set=new RandomizedSet();
        set.insert(5);
        set.insert(1);
        set.insert(6);
        set.remove(5);
    }
}
//设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构：
//
//    insert(val)：当元素 val 不存在时返回 true ，并向集合中插入该项，否则返回 false 。
//    remove(val)：当元素 val 存在时返回 true ，并从集合中移除该项，否则返回 false 。
//    getRandom：随机返回现有集合中的一项。每个元素应该有 相同的概率 被返回。
class RandomizedSet {
    //变长数组可以在 O(1) 的时间内完成随机访问元素操作，但是由于无法在 O(1) 的时间内判断元素是否存在，
    //因此不能在 O(1) 的时间内完成插入和删除操作。哈希表可以在 O(1))的时间内完成插入和删除操作，
    //但是由于无法根据下标定位到特定元素，因此不能在 O(1) 的时间内完成随机访问元素操作。为了满足插入、删除和随机访问元素操作的时间复杂度都是 O(1)，
    //需要将变长数组和哈希表结合，变长数组中存储元素，哈希表中存储每个元素在变长数组中的下标。

    List<Integer> nums;
    Map<Integer,Integer> indices;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums=new ArrayList<Integer>();
        indices=new HashMap<>();
        random=new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(indices.containsKey(val)){
            return false;
        }
        int index=nums.size();
        nums.add(val);
        indices.put(val,index);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!indices.containsKey(val)){
            return false;
        }
        //获取当前值在List下标
        int index=indices.get(val);
        //获取list中最后一个元素的值
        int last=nums.get(nums.size()-1);
        nums.set(index,last);
        indices.put(last,index);
        nums.remove(nums.size()-1);
        indices.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomindex=random.nextInt(nums.size());
        return nums.get(randomindex);
    }
}