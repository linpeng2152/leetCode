package com.linp.leetcode.topic160;

import java.util.ArrayList;
import java.util.List;

/**
 * created by : linpeng
 * ON 2020-03-23
 * used for:
 */
public class Topic152 {


    //
    public static void main(String[] a) {
        int[] arr = {-3,-2};
        System.out.println(maxProduct(arr));
    }

    /**
     * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = 0;
        int[] nuwNums = initArr(nums);
        if (nuwNums.length == 0) {
            return 1;
        }
        if (nuwNums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nuwNums.length; i++) {
            int itemMax = getMax(nuwNums, i);
            max = itemMax > max ? itemMax : max;
        }
        return max;

    }
    public static int maxProduct1(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ int tmp = imax; imax = imin; imin = tmp;} //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;

    }

    public static int[] initArr(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i != nums.length -1){
                if (nums[i] == nums[i + 1] && nums[i] == -1) {
                    nums[i] = 1;
                    nums[i + 1] = 1;
                    list.add(nums[i]);
                }
            }
            if (nums[i] != 1) {
                list.add(nums[i]);
            } else if (!list.contains(1)) {
                list.add(nums[i]);
            }

        }


        int[] newNums = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            newNums[i] = list.get(i);
        }

        return newNums;
    }

    public static int getMax(int[] nums, int i) {
        int[] numV = new int[nums.length];
        int itemMax = nums[i];
        int itemMaxV = nums[i];
        numV[0] = itemMax;
        for (int j = i + 1; j < nums.length; j++) {
            itemMaxV = nums[i];
            for (int z = i + 1; z <= j; z++) {
                itemMaxV = itemMaxV * nums[z];
            }
            itemMax = itemMaxV > itemMax ? itemMaxV : itemMax;
        }
        return itemMax;
    }
}
