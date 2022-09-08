package com.chenghaixiang.jianzhi2.day12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office038 {
}
//请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
class Solution02 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        // 创建一个单调栈
        Deque<Integer> stack=new ArrayDeque<>();
        int i=0;
        while (i<temperatures.length){
            // 当栈为空，或者当前元素 <= 栈顶元素，则将当前元素的索引进栈，形成栈底到栈顶的递减栈
            // 同时，将 i 指向下一天的温度
            if(stack.isEmpty()||temperatures[stack.peek()]>=temperatures[i]){
                //栈中存取的是temperatures中温度所在的下标
                stack.push(i++);
            }else {
                // 如果当前元素 > 栈顶元素，则将栈顶索引出栈，说明找到了比栈顶索引更高的温度，获取对应的天数。
                Integer top=stack.pop();
                res[top]=i-top;
            }
        }
        return res;

    }
}