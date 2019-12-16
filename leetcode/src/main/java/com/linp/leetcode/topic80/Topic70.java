package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-13 15:22
 * used for:
 */

public class Topic70 {

    public static void main(String[] args) {

        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }

    public  static int climbStairs(int n) {
        if(n <= 3){
            return n;
        }

        int a1 = 1;
        int a2 = 2;

        int index = 2;
        int temp = 3;
        while(index < n){
            temp = a1 + a2;
            a1 = a2;
            a2 = temp;
            index ++;
        }
        return temp;

    }



}
