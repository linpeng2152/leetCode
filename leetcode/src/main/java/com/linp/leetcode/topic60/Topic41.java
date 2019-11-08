package com.linp.leetcode.topic60;


import java.util.Arrays;

/**
 * created by : linpeng
 * ON 2019-11-08 14:14
 * used for:
 */

public class Topic41 {

    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     *
     * 示例 1:
     *
     * 输入: [1,2,0]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [3,4,-1,1]
     * 输出: 2
     * 示例 3:
     *
     * 输入: [7,8,9,11,12]
     * 输出: 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-missing-positive
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int firstMissingPositive(int[] nums) {

        Arrays.sort(nums);
        int d = 1;
        int length = nums.length;
        if(nums.length == 0 || nums[0] > 1 || nums[length - 1]< 1){
            return 1;
        }

        for(;;){
            for(int i=0; i<nums.length - 1; i++) {


                if (nums[i] < d && d < nums[i + 1]) {
                    return d;
                }

            }
            d++;
            if(d ==  nums[nums.length - 1] +1){
                return d;
            }

        }

    }

    public static void main(String args[]){
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }

}
