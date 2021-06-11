package com.linp.leetcode.topic220;

/**
 * @Author : linpeng
 * ON 2021-02-05
 * used for:
 */
public class Topic219 {

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     *
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0){
            return false;
        }
        for(;k>=1;k--){
            for(int i =0;i<nums.length && i + k < nums.length;i++){
                if(nums[i] ==  nums[i + k]){
                    return true;
                }
            }
        }
        return false;
    }
}
