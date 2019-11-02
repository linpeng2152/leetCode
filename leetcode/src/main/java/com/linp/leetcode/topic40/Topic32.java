package com.linp.leetcode.topic40;


/**
 * created by : linpeng
 * ON 2019-11-02 15:44
 * used for:
 */

public class Topic32 {

    public static int longestValidParentheses(String s) {
        int size = s.length();
        int len = s.length();

        for(int j = len;  j > 0; j--){
            for(int i = 0; i + j <= size;i++){
                String subStr = s.substring(i,j+i);
                if(check(subStr)){
                    return j;
                }
            }
        }


        return 0;
    }

    public static boolean check(String str){
        int len = str.length();
        int count = 0;
        for (int i = 0; i<len; i++){
            if("(".equals(String.valueOf(str.charAt(i)))){
                count++;
            }
            if(")".equals(String.valueOf(str.charAt(i)))){
                count--;
                if(count<0){
                    return false;
                }
            }
        }
        if(count == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        longestValidParentheses("(()");
    }

}
