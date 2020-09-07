package com.linp.code.beautiful;

/**
 * @Author : linpeng
 * ON 2020-04-27
 * used for:
 */
public class Topic1 {

    /**
     * 1的数目
     *
     *  给定一个十进制正整数N 写下1 开始，到N的所有整数，然后数一下其中出现的所有 1 的个数
     *
     *  例如:
     *  N = 2 写下 1，2 这样出现的1的个数 1
     *  N = 12，写下1，2，3，4，5，6，7，8，9，10，11，12 总 5个数
     *
     *  问题
     *  1、写一个函数 f(N) 返回1到N之间出现的 1 的个数 f（12） = 5
     *  2、在32位整数范围，满足条件 f（N） = N 的最大的N
     */

    public static void main(String[] agr){
        int N =  2199992 - 1999991;
        int count1 = f(N);
        System.out.println(N);

    }
    public static int f(int n){
        //最笨的办法 能解第一问题
        return f1(n);
    }
    public static int f1(int n){
        StringBuilder sb = new StringBuilder("");
        for(int i = 1;i<=n;i++){
            sb.append (""+i);
        }
        int count = 0;
        for(char c : sb.toString().toCharArray()){
            if('1' ==c){
                count ++;
            }
        }
        return count;
    }

    public static int f2(int n){
        int count = 0;
//        while (n / 10 != 0){
//            count + ( n / 10 =
//
//
//
//
//        }

        return count;

    }

}
