package com.linp.leetcode.topic20;


import java.util.HashMap;
import java.util.Map;

/**
 * created by : linpeng
 * ON 2019-10-30 11:15
 * used for:
 */

public class Topic12 {


    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    public static String intToRoman(int num, String str) {
        if (num >= 1000) {
            str += "M";
            num -= 1000;
        } else if (num >= 900) {
            str += "CM";
            num -= 900;
        } else if (num >= 500) {
            str += "D";
            num -= 500;
        } else if (num >= 400) {
            str += "CD";
            num -= 400;
        } else if (num >= 100) {
            str += "C";
            num -= 100;
        } else if (num >= 90) {
            str += "XC";
            num -= 90;
        } else if (num >= 50) {
            str += "L";
            num -= 50;
        } else if (num >= 40) {
            str += "XL";
            num -= 40;
        } else if (num >= 10) {
            str += "X";
            num -= 10;
        } else if (num >= 9) {
            str += "IX";
            num -= 9;
        } else if (num >= 5) {
            str += "V";
            num -= 5;
        } else if (num >= 4) {
            str += "IV";
            num -= 4;
        } else if (num >= 1) {
            str += "I";
            num -= 1;
        } else {
            return str;
        }
        return intToRoman(num, str);
    }

    public static void main(String[] args) {

        System.out.println(intToRoman(58,""));
    }

}
