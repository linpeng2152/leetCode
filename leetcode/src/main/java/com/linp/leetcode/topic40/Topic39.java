package com.linp.leetcode.topic40;


import java.util.*;

/**
 * created by : linpeng
 * ON 2019-11-08 11:37
 * used for:
 */

public class Topic39 {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     * <p>
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     * [7],
     * [2,2,3]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Set<String> s = new HashSet<String>();

        Arrays.sort(candidates);

        int length = candidates.length;

        for (int i = 0; i < candidates.length; i++) {
            if(target == 1 && candidates[i] == 1){
                List<Integer>   list = new ArrayList<>();
                list.add(1);
                result.add(list);
                return result;
            }
            addToTarget(candidates, target, i, 0, null, result,s);

        }
        return result;
    }


    public static void addToTarget(int[] candidates, int target, int i, int cur, List<Integer> oldList, List<List<Integer>> result,Set<String> s) {
        List<Integer> list;
        if (oldList == null) {
            list = new ArrayList<>();
        } else {
            list = new ArrayList<>();
            list.addAll(oldList);
        }

        list = (list == null) ? new ArrayList<Integer>() : list;
        cur += candidates[i];
        if (cur > target) {
            return;
        }
        list.add(candidates[i]);

        if (cur == target) {
            addToList(list, result,s);
            return;
        }

        for (int j = i + 1; j < candidates.length; j++) {

            addToTarget(candidates, target, j, cur, list, result,s);

        }

    }

    public static Set<String> s = new HashSet<String>();


    public static void addToList(List<Integer> list, List<List<Integer>> result,Set<String> s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        if (s.add(sb.toString())) {
            result.add(list);
        }
    }


    public static void main(String[] args){
        List<List<Integer>> result = combinationSum(new int[]{1,1},1);
        for(int i = 0; i < result.size(); i++){
            List<Integer> item = result.get(i);
            for(int j = 0; j < item.size(); j++){
                System.out.print(item.get(j));
            }

            System.out.println();


        }

    }
}