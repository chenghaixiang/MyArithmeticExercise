

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.zip.GZIPInputStream;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Test {
    public static void main(String[] args) {
        double[] score=new double[2];
        HashMap<Integer,Double[]> map=new HashMap<>();
        boolean as=true;
        Scanner scanner=new Scanner(System.in);
        Integer i=0;
        System.out.println("开始输入程序");
        while (as){
            Double[] doubles=new Double[2];
            System.out.println("绩点和学分");
            for (int j=0;j<2;j++){
                doubles[j]=scanner.nextDouble();
            }
            map.put(i,doubles);
            i++;
            int a=0;
            a=scanner.nextInt();
            if (a==-1){
                as=false;
            }
        }
        double sum=0;
        double sumscore=0;
        for (Integer key:map.keySet()){
            sum=map.get(key)[1]+sum;
            sumscore=map.get(key)[0]*map.get(key)[1]+sumscore;
        }
        System.out.println(sumscore+" "+sum);
        System.out.println("绩点："+sumscore/sum);
    }

}

