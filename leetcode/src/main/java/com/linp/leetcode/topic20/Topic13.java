package com.linp.leetcode.topic20;


/**
 * created by : linpeng
 * ON 2019-10-30 17:07
 * used for:
 */

public class Topic13 {


    public int romanToInt(String s,int num) {
        if(s.startsWith("M")){
            num += 1000;
            s =s.substring(1);
        }else if(s.startsWith("CM")){
            num += 900;
            s =s.substring(2);
        }else if(s.startsWith("D")){
            num += 500;
            s =s.substring(1);
        }else if(s.startsWith("CD")){
            num += 400;
            s =s.substring(2);
        }else if(s.startsWith("C")){
            num += 100;
            s =s.substring(1);
        }else if(s.startsWith("XC")){
            num += 90;
            s =s.substring(2);
        }else if(s.startsWith("L")){
            num += 50;
            s =s.substring(1);
        }else if(s.startsWith("XL")){
            num += 40;
            s =s.substring(2);
        }else if(s.startsWith("X")){
            num += 10;
            s =s.substring(1);
        }else if(s.startsWith("IX")){
            num += 9;
            s =s.substring(2);
        }else if(s.startsWith("V")){
            num += 5;
            s =s.substring(1);
        }else if(s.startsWith("IV")){
            num += 4;
            s =s.substring(2);
        }else if(s.startsWith("I")){
            num += 1;
            s =s.substring(1);
        } else {
            return num;
        }
        return romanToInt(s,num);
    }

    public static void main(String args[]){
        System.out.println("");
    }
}
