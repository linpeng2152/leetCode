package com.linp.leetcode.topic40;


/**
 * created by : linpeng
 * ON 2019-11-02 11:20
 * used for:
 */

public class Topic28 {


    public int strStr(String haystack, String needle) {
        if(haystack == null || needle== null || "".equals(needle)||"".equals(haystack)){
            return -1;
        }
        if(!haystack.contains(needle)){
            return -1;
        }
        if(haystack.startsWith(needle)){
            return 0;
        }
        String[] arr = haystack.split(needle);
        return arr[0].length();
    }
}
