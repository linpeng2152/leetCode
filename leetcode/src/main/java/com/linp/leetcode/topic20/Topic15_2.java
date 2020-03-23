package com.linp.leetcode.topic20;


import java.util.*;

/**
 * created by : linpeng
 * ON 2019-10-30 18:12
 * used for:
 */

public class Topic15_2 {


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<String> check = new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int x = j + 1; x < nums.length; x++) {
                    if (nums[i] + nums[j] + nums[x] == target) {
                        s.clear();
                        s.add(i);
                        s.add(j);
                        s.add(x);
                        if (s.size() != 3) {
                            continue;
                        }


                        int[] a = {nums[i], nums[j], nums[x]};
                        if (addCheck(check, a)) {
                            List<Integer> l = new ArrayList<>();
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[x]);
                            list.add(l);
                        }
                    }

                }

            }
        }
        return list;

    }

    private static boolean addCheck(List<String> check, int[] arr) {
        Arrays.sort(arr);
        String s = "";
        for (int i : arr) {
            s += "," + i;
        }
        if (check.contains(s)) {
            return false;
        }
        check.add(s);
        return true;

    }

}
