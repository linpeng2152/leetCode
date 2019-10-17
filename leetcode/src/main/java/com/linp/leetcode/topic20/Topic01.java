package com.linp.leetcode.topic20;


/**
 * created by : linpeng
 * ON 2019-10-17 17:56
 * used for:
 */

public class Topic01 {

    /**
     * 描述 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * <p>
     * 实例
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum(int[] arr, int target) {
        int[] result = new int[2];

        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] + arr[j] == target) {

                    return new int[]{i, j};

                }
            }


        }

        return null;


    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 18);


        System.out.println (result[0] + "   "+ result[1]);

    }

}
