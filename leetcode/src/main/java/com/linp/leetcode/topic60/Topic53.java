package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-28 09:20
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic53 {


    public static int maxSubArray(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        boolean isBig0 = true;
        int lastCount = 0;
        for (int i = 0; i < len; i++) {
            int item = nums[i];
            if (item == 0) {
                continue;
            }
            if (i == 0 && item <= 0) {
                continue;
            }

            if (isBig0) {
                if (item > 0) {
                    lastCount += item;
                } else {
                    l.add(lastCount);
                    isBig0 = false;
                    lastCount = 0;
                }
            } else {
                if (item < 0) {
                    lastCount += item;
                } else {
                    l.add(lastCount);
                    isBig0 = true;
                    lastCount = 0;
                }
            }
        }
        l.add(lastCount);

        int data = 0;
        int len2 = l.size();

        for (int i = 0; i < len2; i++) {

        }

        return 0;
    }


    public static int maxSubArray1(int[] nums) {

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int itemMax =getMax(nums,i);
            if (max < itemMax){
                max = itemMax;
            }
        }
        return max;
    }

    private static int getMax(int[] nums, int i) {
        int max = nums[i];
        int len = nums.length;
        int cur = nums[i];
        for (int j = i; j < len; j++) {
            if (j == i) {
                continue;
            }
            cur = cur + nums[j];
            if (max <= cur) {
                max = cur;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

}
