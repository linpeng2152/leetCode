package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-11 11:55
 * used for:
 */

public class Topic65 {

    /**
     * 1、判断字符串是否全是 " "
     * 2、当字符串包含" "
     *      1、去除头部" "
     *      2、去除尾部" "
     *      3、如果还包含" "，返回 false
     * 3、判断是否能直接变成数字
     * 4、如果字符串不包含"e" 返回false、包含"e"
     *      1、以"e"开头或者结尾直接返回 false
     *      2、用"e"切分 前面是Double、后面是整数返回true
     */
    public static boolean isNumber(String s) {
        if(s.trim().length() < 1){
           return false;
        }

        if(s.contains(" ")){
            if(s.trim().length() == 0){
                return false;
            }

            while(s.startsWith(" ")){
                s = s.substring(1);
            }
            while(s.endsWith(" ")){
                s = s.substring(0,s.length()-1);
            }
            if(s.contains(" ")){
                return false;
            }
        }

        if (isNumber1(s)) {
            return true;
        }
        return isNumber2(s);
    }


    public static boolean isNumber1(String s) {
        try {
            if(s.contains("f") || s.contains("F")||s.contains("d")||s.contains("D")){
                return false;
            }

            Double d = Double.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean isNumber2(String s) {
        if (s.contains("e")) {
            if(s.endsWith("e") || s.startsWith("e")){
                return false;
            }
            String[] s2 = s.split("e");
            if(s2.length != 2){
                return false;
            }

            if (s2[1].contains(".")) {
                return false;
            }
            if (isNumber1(s2[0]) && isNumber1(s2[1])) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(isNumber("e9"));


    }
}
