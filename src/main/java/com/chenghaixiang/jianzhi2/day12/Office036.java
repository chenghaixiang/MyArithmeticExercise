package com.chenghaixiang.jianzhi2.day12;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office036 {
}
//后缀表达式由波兰的逻辑学家卢卡西维兹提出，也称逆波兰表达式。后缀表达式的特点是：没有括号，运算符总是放在和它相关的操作数之后。
//根据 逆波兰表示法，求该后缀表达式的计算结果。
//
//有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new LinkedList<>();
        int n=tokens.length;
        for(int i=0;i<n;i++){
            String token=tokens[i];
            if(isNumber(token)){
                stack.push(Integer.parseInt(token));
            }else {
                //弹出数字
                int num2=stack.pop();
                int num1=stack.pop();
                switch (token){
                    case "+":
                        //计算结果压入栈
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num1-num2);
                        break;
                    case "*":
                        stack.push(num1*num2);
                        break;
                    case "/":
                        stack.push(num1/num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    //判断是否为数字，是返回true
    boolean isNumber(String token){
        return !("+".equals(token)||"-".equals(token)||"*".equals(token)||"/".equals(token));
    }
}