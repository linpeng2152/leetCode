package com.linp.leetcode.topic40;


import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * created by : linpeng
 * ON 2019-11-02 11:26
 * used for:
 */

public class Topic29 {

    public static int divide(int dividend, int divisor) {

        boolean check = true;

        if(dividend > 0 && divisor < 0){
            check = false;

        }else
        if(dividend < 0 && divisor > 0){
            check = false;
        }

        if(dividend == Integer.MIN_VALUE){
            dividend = 1+dividend;
        }

        int newDividend = dividend < 0 ? 0 - dividend : dividend;
        int newDivisor = divisor < 0 ? 0 - divisor : divisor;
        if(newDividend < newDivisor){
            return 0;
        }

        int i = 0;
        if(newDivisor == 1){
            i = newDividend;
        }


         i= getDiv(newDividend,newDivisor);
        if(check){
            return i;
        }
        return 0 - i;
    }




    public static  int  getDiv(int newDividend, int newDivisor){
        int i = 0;
        int cur = newDivisor;
        while(cur <= newDividend){
            cur += newDivisor;
            i ++;
        }
        return i;
    }

    public static  int  getDiv2(int newDividend, int newDivisor){
        int i = 1;
        int cur = newDivisor;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        if(newDivisor > newDividend){
            return 0;
        }
        map.put(i,cur);
        while(cur + cur < newDividend){
            i = i + i;
            cur = cur + cur;
            map.put(i,cur);
        }





        return i;
    }

    public static int getMind(Map<Integer,Integer> map,int curDividend){
        Set<Integer> set = map.keySet();
        List<Integer> l = set.stream().collect(Collectors.toList());
        for(int i=set.size() -1 ;i>=0;i--){
            int val = map.get(l.get(i));



        }


        return 1;

    }




    public static void main(String[] args){
        divide(1
                ,1);
    }
}
