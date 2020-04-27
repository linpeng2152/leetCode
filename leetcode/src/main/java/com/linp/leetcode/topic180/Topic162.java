package com.linp.leetcode.topic180;

/**
 * @Author : linpeng
 * ON 2020-04-13
 * used for:
 */
public class Topic162 {

    /**
     * 峰值元素是指其值大于左右相邻值的元素。
     * <p>
     * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
     * <p>
     * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
     * <p>
     * 你可以假设 nums[-1] = nums[n] = -∞。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,1]
     * 输出: 2
     * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
     * 示例 2:
     * <p>
     * 输入: nums = [1,2,1,3,5,6,4]
     * 输出: 1 或 5
     * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
     *      或者返回索引 5， 其峰值元素为 6。
     * 说明:
     * <p>
     * 你的解法应该是 O(logN) 时间复杂度的。
     * <p>
     * 通过次数35,964提交次数78,648
     * 在真实的面试中遇到过这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-peak-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int[] arr = {3,2,3,1};

        System.out.println(findPeakElement(arr));

    }


    public static int findPeakElement(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
           if(check(nums,i)){
                return i;
           }
        }

        return -1;

    }

    public static boolean check(int[] nums, int i) {
        int min = i - 1 >= 0 ? nums[i - 1] : Integer.MIN_VALUE;
        int max = i + 1 < nums.length ? nums[i + 1] : Integer.MIN_VALUE;
        int m =  nums[i];

        boolean t = true;
        if(min != Integer.MIN_VALUE &&  min > m){
            t = false;
        }
        if(max != Integer.MIN_VALUE &&  max > m){
            t = false;
        }
        return t;

    }
}
