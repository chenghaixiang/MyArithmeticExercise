package com.chenghaixiang.jianzhi1.day01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Offer30 {
    public static void main(String[] args) {
        MinStack stack=new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.top());
    }
}

class MinStack{
    Deque<Integer> Stack;
    //minStack是存放最小值的栈
    Deque<Integer> minStack;

    public MinStack(){
        Stack=new ArrayDeque<Integer>();
        minStack=new ArrayDeque<Integer>();
        //minStack栈压入一个默认的值，为Int的最大值
        minStack.push(Integer.MAX_VALUE);
    }
   public void push(int x){
        //同时将x入两个栈
        Stack.push(x);
        //压入是比较栈顶元素和压入元素大小，压入元素小于栈顶元素，压入，否则再次压入顶部元素，因为顶部元素本来就最小值，minStack存放的是Stack栈的最小值
       //.peek()是返回这个栈的顶部元素
       if(x<minStack.peek()){
           minStack.push(x);
       }else {
           minStack.push(minStack.peek());
       }
//        minStack.push(Math.min(minStack.peek(),x));
   }
   public void pop(){
        Stack.pop();
        minStack.pop();
    }
    public int top(){
        return Stack.peek();
    }
    public int min(){
        return minStack.peek();
    }
}