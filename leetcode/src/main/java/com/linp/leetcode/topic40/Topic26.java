package com.linp.leetcode.topic40;


import java.util.HashSet;
import java.util.Set;

/**
 * created by : linpeng
 * ON 2019-11-02 10:49
 * used for:
 */

public class Topic26 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        int j = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            if(set.add(nums[i])){
                j++;
            }
        }

        return j;
    }
}
