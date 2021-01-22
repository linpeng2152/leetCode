package com.linp.leetcode.top;

import java.util.*;

/**
 * @Author : linpeng
 * ON 2020-12-21
 * used for:
 */
public class Topic4 {


    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     * <p>
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     * <p>
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     * <p>
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     * <p>
     * 提示：
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     * 通过次数305,979提交次数778,639
     */

    public static double findMedianSortedArrays(Integer[] nums1, Integer[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 == 0){
            return onlyOne(nums2);
        }
        if(len2 == 0){
            return onlyOne(nums2);

        }
        boolean isDouble = false;
        if ((len1 + len2) % 2 == 0) {
            isDouble = true;
        }

        return 0.0D;

    }

    private static void remove2( List<Integer> l1, List<Integer> l2){
        int min1 = l1.get(0);
        int min2 = l2.get(0);

        int max1 = l1.get(l1.size() - 1);
        int max2 = l2.get(l2.size() - 1);
        if(min1 < min2){
            l1.remove(0);
        }else {
            l2.remove(0);
        }
        if(max1 > max2){
            l1.remove(l1.size() - 1);
        }else {
            l2.remove(l2.size() - 1);
        }
    }


    private  static double onlyOne(Integer[] nums){
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        if(len % 2 == 0){
            int min = len / 2 - 1;
            int max = len / 2 + 1;
            return (nums[min] + nums[max])/2;
        }else {
            int index = len / 2 + 1;
            return (nums[index])/2;
        }
    }


    public static void main(String[] a) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 7};

//        System.out.println(findMedianSortedArrays(nums1, nums2));

        System.out.println(System.currentTimeMillis() + 5000);
        System.out.println(System.currentTimeMillis() - 1607011745623L);


    }


}
