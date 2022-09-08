package com.chenghaixiang.jianzhi1.day26;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class office20 {
}
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//
//数值（按顺序）可以分成以下几个部分：
//
//    若干空格
//    一个 小数 或者 整数
//    （可选）一个 'e' 或 'E' ，后面跟着一个 整数
//    若干空格
//
//小数（按顺序）可以分成以下几个部分：
//
//    （可选）一个符号字符（'+' 或 '-'）
//    下述格式之一：
//        至少一位数字，后面跟着一个点 '.'
//        至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
//        一个点 '.' ，后面跟着至少一位数字
//
//整数（按顺序）可以分成以下几个部分：
//
//    （可选）一个符号字符（'+' 或 '-'）
//    至少一位数字
class Solution {
    //使用有限状态自动机
    public boolean isNumber(String s) {
        Map[] states={
                new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<>() {{ put('d', 3); }},                                        // 4.
                new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<>() {{ put('d', 7); }},                                        // 6.
                new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<>() {{ put(' ', 8); }}                                         // 8.
        };
        int p=0;
        char t;
        for(char c:s.toCharArray()){
            if(c>='0'&&c<='9'){
                t='d';
            }else if(c=='+'||c=='-'){
                t='s';
            }else if(c=='e'||c=='E'){
                t='e';
            }else if(c=='.'||c==' '){
                t=c;
            }else {
                t='?';
            }
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}