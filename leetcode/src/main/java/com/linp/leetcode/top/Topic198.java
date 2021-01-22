package com.linp.leetcode.top;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author : linpeng
 * ON 2021-01-19
 * used for:
 */
public class Topic198 {


    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[ 1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     * <p>
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     */

    public static int rob(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        Set<Integer> set = new TreeSet<>();

        rob(arr,arr.length, 0, arr[0], set);
        rob(arr,arr.length, 1, arr[1], set);

        int max = 0;
        for (Integer i : set) {
            max = i;
        }
        return max;
    }


    public static void rob(int[] arr,int len, int index, int result, Set<Integer> set) {
        if (index == len - 1 || index == len - 2) {
            set.add(result);
        }

        if (index + 2 <= len - 1) {
            rob(arr,len, index + 2, result + arr[index + 2], set);
        }
        if (index + 3 <= arr.length - 1) {
            rob(arr, len,index + 3, result + arr[index + 3], set);
        }
    }


    /**
     * 小的数组没问题
     * 大的数组超时
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,
                46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,
                62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,
                120,180,249,106,37,169,225,54,103,55,166,124};
        System.out.println(rob(arr));

    }
}
