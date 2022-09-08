package com.chenghaixiang.jianzhi1.day19;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office64 {
}
//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
class Solution {
    int res = 0;
    //使用递归,因为有限制，所以用短路与判断
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}