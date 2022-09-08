package com.chenghaixiang.jianzhi2.day16;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Office048 {
}
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
//请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

//深度优先搜索
class Codec {

    //序列化
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root,"");
    }

    String rserialize(TreeNode root,String str){
        if(root==null){
            str=str+"None,";
        }else {
            //将int类型转换为String
            str+=str.valueOf(root.val)+",";
            str=rserialize(root.left,str);
            str=rserialize(root.right,str);
        }
        return str;
    }

    //反序列化
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray=data.split(",");
        //Arrays.asList返回由指定数组支持的固定大小的列表。
        List<String> dataList=new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    TreeNode rdeserialize(List<String> dataList){
        if(dataList.get(0).equals("None")){
            dataList.remove(0);
            return null;
        }

        //将链表的值还原成二叉树
        TreeNode root=new TreeNode(Integer.valueOf(dataList.get(0)));
        //还原后删除当前值
        dataList.remove(0);
        //深度优先搜索递归
        root.left=rdeserialize(dataList);
        root.right=rdeserialize(dataList);
        return root;
    }
}