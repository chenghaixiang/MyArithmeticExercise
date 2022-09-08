package com.chenghaixiang.jianzhi2.day12;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office037 {
    public static void main(String[] args) {
        int[] aa={1,10,-15};
        Solution01 solution01=new Solution01();
        solution01.asteroidCollision(aa);
    }
}
//给定一个整数数组 asteroids，表示在同一行的小行星。
//
//对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
//
//找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

class Solution01 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stacks=new LinkedList<>();
        for(int aster:asteroids){
            boolean alive=true;
            //当栈不为空，当前小行星方向为左，前一个小行星方向为右时进入
            while (alive&&aster<0&&!stacks.isEmpty()&&stacks.peek()>0){
                if(stacks.peek()<-aster){
                    alive=true;
                }else {
                    alive=false;
                }
                // 栈顶小行星爆炸,就是当前值的前一个小行星爆炸
                if(stacks.peek()<=-aster){
                    stacks.pop();
                }
            }
            if(alive){
                stacks.push(aster);
            }
        }
        int size=stacks.size();
        //将栈中元素取出
        int[] res=new int[size];
        for (int i=size-1;i>=0;i--){
            res[i] =stacks.pop();
        }
        return res;
    }
}