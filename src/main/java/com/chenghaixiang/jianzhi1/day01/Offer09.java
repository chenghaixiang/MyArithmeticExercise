package com.chenghaixiang.jianzhi1.day01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Offer09 {
   public static void main(String[] args) {
      CQuece cQuece=new CQuece();
      System.out.println(cQuece.deleteHead());
      cQuece.appendTail(3);
      cQuece.appendTail(5);
      System.out.println(cQuece.deleteHead());
      System.out.println(cQuece.deleteHead());
   }
}
//两栈模拟队列，leetcode上的题
class CQuece{
   Deque<Integer> inStack;
   Deque<Integer> outStack;
   public CQuece(){
      //初始化两个栈
      inStack=new ArrayDeque<Integer>();
      outStack=new ArrayDeque<Integer>();
      System.out.println("null");
   }
   public void appendTail(int value){
      //添加元素进栈
      inStack.push(value);
      System.out.println("null");
   }
   public int deleteHead(){
      //out栈没有元素,进入下个判断
       if (outStack.isEmpty()){
          //int栈没有元素，证明没有元素弹出,返回-1
          if (inStack.isEmpty()){
             return -1;
          }
          in2out();
       }
       return outStack.pop();
   }
   private void in2out(){
      //将int栈中元素添加到out栈，因为栈是先进后出，所以放到out栈时顺序是倒过来的,栈对象名.pop()方法是弹出一个顶部元素
      while (!inStack.isEmpty()){
         outStack.push(inStack.pop());
      }
   }
}