package com.linp.leetcode.topic20;

/**
 * created by : linpeng
 * ON 2020-03-20
 * used for:
 */


import java.util.*;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * 通过次数64,142提交次数171,603
 * 在真实的面试中遇到过这道题？
 */
public class Topic18 {

    /**
     * 代码 糟糕 效率底
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<String> check =  new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        for(int i =0 ;i<nums.length;i++){
            for(int j=i+1;j <nums.length;j++){
                for(int x=j+1;x<nums.length;x++){
                    for(int y=i+1;y <nums.length;y++){
                        if(nums[i]+nums[j]+nums[x]+nums[y] == target){
                            s.clear();
                            s.add(i);
                            s.add(j);
                            s.add(x);
                            s.add(y);
                            if(s.size() != 4){
                                continue;
                            }


                            int[] a = {nums[i],nums[j],nums[x],nums[y]};
                            if(addCheck(check,a)){
                                List<Integer> l = new ArrayList<>();
                                l.add(nums[i]);
                                l.add(nums[j]);
                                l.add(nums[x]);
                                l.add(nums[y]);
                                list.add(l);
                            }
                        }

                    }
                }
            }
        }
        return  list;

    }

    private static boolean addCheck(List<String> check,int[] arr){
        Arrays.sort(arr);
        String s = "";
        for(int i :arr){
            s += ","+i;
        }
        if(check.contains(s)){
            return false;
        }
        check.add(s);
        return true;

    }

    public static void main(String[] args){
     int[] arr = {1, 0, -1, 0, -2, 2};
     int target = 0;
     List<List<Integer>> l = fourSum(arr,target);


    }


}
