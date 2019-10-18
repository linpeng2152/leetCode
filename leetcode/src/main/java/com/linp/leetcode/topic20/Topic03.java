package com.linp.leetcode.topic20;


import java.util.HashSet;
import java.util.Set;

/**
 * created by : linpeng
 * ON 2019-10-18 14:59
 * used for:
 */

public class Topic03 {


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     */
    public static int  lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 1;
        for(int i=0; i<length; i++){
            for(int j=0; j<length-i; j++){
                String subStr = s.substring(i,length - j);
                if(check(subStr)){
                    if(max < length - i - j){
                        max = length - i - j;
                    }
                }
            }
        }

        return max;

    }

    public static boolean check(String str){
        char[] arr = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c:arr){
            set.add(c);
        }
        if(set.size() == arr.length){
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        String str = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(str));

    }

}
