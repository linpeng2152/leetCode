package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-08 15:39
 * used for:
 */

public class Topic43 {

    public String multiply(String num1, String num2) {






        try{

            Double n1 = Double.parseDouble(num1);
            Double n2 = Double.parseDouble(num2);
            Double n3 = n1 * n2;

            String  str = n3.toString();
            int index =str.indexOf(".");




            return  str.substring(0,index);
        }catch(Exception e){
            return "0";
        }

    }
}
