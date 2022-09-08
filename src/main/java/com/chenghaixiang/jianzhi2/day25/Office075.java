package com.chenghaixiang.jianzhi2.day25;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office075 {
}
//给定两个数组，arr1 和 arr2，
//
//    arr2 中的元素各不相同
//    arr2 中的每个元素都出现在 arr1 中
//
//对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
class Solution01 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }
        int[] a;
        //排序规则
        //自定义比较器只接受泛型
        Comparator cmp=new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                if(map.containsKey(a)&&map.containsKey(b)){
                    return map.get(a)-map.get(b);
                }else if(map.containsKey(a)){
                    return -1;
                }else if(map.containsKey(b)){
                    return 1;
                }else {
                    return a-b;
                }
            }
        };
        //1、Collectors.toList() 将流中的所有元素导出到一个列表( List )中
        //
        //2、流式操作可以经过运算（map）、筛选（filter）、排序、操作……返回我们需要的集合
        //Arrays.stream(arr1)得到是int类型的数据流，boxed将它转换成Integer
        List<Integer> list = Arrays.stream(arr1).boxed().collect(Collectors.toList());
//        List<Integer> list=new ArrayList<>();
//        for(int i=0;i<arr1.length;i++){
//            Integer a=arr1[i];
//            list.add(a);
//        }
        list.sort(cmp);
        //stream()中的maptoint(ToIntFunction mapper)返回一个IntStream其中包含给定函数应用于此流得元素的结果
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}