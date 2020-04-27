package com.linp.leetcode.topic180;

import java.math.BigDecimal;

/**
 * @Author : linpeng
 * ON 2020-04-13
 * used for:
 */
public class Topic172 {

    /**
     *
     给定一个整数 n，返回 n! 结果尾数中零的数量。

     示例 1:

     输入: 3
     输出: 0
     解释: 3! = 6, 尾数中没有零。
     示例 2:

     输入: 5
     输出: 1
     解释: 5! = 120, 尾数中有 1 个零.
     说明: 你算法的时间复杂度应为 O(log n) 。
     */

    public static void main(String[] args){
        System.out.println(trailingZeroes(30));


        for(int i= 0;i<100;i++){
//            BigDecimal v =   trailingZeroes(i);
//            System.out.print("   :  " + i + " == " +t(v.toString()));
            int m = trailingZeroes2(i);
            System.out.print("   :  " + i + " == " +m);

            if(i % 10 == 0){
              System.out.println();
          }
        }
    }

    public static BigDecimal trailingZeroes(int n) {
        BigDecimal m = new BigDecimal(1);
        for(int i= n;i>1;i--){
            m = m.multiply(new BigDecimal(i));
        }
        return m;
    }

    public static int trailingZeroes2(int n) {



        int m = 0;

        while (n >= 5){
            m  += n/5;
            n = n/5;
        }


       return m;
    }

    private static int t(String n){
        int i = 0;
        while (n.endsWith("0")){
            i++;
            n = n.substring(0,n.length()-1);
        }
        return i;

    }




}
