package com.linp.leetcode.topic20;


/**
 * created by : linpeng
 * ON 2019-10-30 17:44
 * used for:
 */

public class Topic14 {

    public  static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length <= 1){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        int len = first.length();
        if(first.length() <2){
            if(!isCommon(strs,first)){
                return "";
            }else{
                return first;

            }
        }

        String cur = "";
        String f = null;
        for(int i = 0; i < len+1;i++){
            f = first.substring(0,i);
            if(!isCommon(strs,f)){
                return cur;
            }else{
                cur = f;
            }
        }
        return cur;

    }
    public static boolean isCommon(String[] arr,String subStr){
        for(String str:arr){
            if(!str.startsWith(subStr)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] strs = {"aa","aabc","aac","aac","aa"};

        System.out.println(longestCommonPrefix(strs));
    }
}
