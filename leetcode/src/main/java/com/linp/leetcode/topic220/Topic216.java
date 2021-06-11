package com.linp.leetcode.topic220;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : linpeng
 * ON 2021-02-05
 * used for:
 */
public class Topic216 {


    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     * <p>
     * 说明：
     * <p>
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     * <p>
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 示例 2:
     * <p>
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     */
    public static List<List<Integer>> combinationSum(int k, int n) {

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            List<Integer> item = new ArrayList<>();
            item.add(i);
            t(list, item, k, n, i, i);
        }
        return list;
    }


    public static void t(List<List<Integer>> list, List<Integer> item, int k, int n, int last, int count) {
        if (count > n) {
            return;
        }
        if (count == n && item.size() == k) {
            list.add(item);
            return;
        }
        if (count < n && last < 9) {

            for (int i = last; i < 9; i++) {
                List<Integer> newItem = copy(item);
                if (n - count > i) {
                    newItem.add(i + 1);
                    t(list, newItem, k, n, i + 1, count + i + 1);
                }
            }
        }
    }

    private static List<Integer> copy(List<Integer> item) {
        return item.stream().map(i -> i).collect(Collectors.toList());
    }


    public static void main(String[] a) {
        combinationSum(3, 9);
    }
}
