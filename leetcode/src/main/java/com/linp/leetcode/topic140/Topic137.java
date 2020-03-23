package com.linp.leetcode.topic140;


/**
 * created by : linpeng
 * ON 2020-01-10 16:23
 * used for:
 */

import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic137 {

    public static void main(String[] args){
//        int[] arr = {2,2,3,2};
        int[] arr = {0,100,0,100,0,100,99};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int lne = nums.length;
        if(lne == 1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[lne-1] != nums[lne-2]){
            return nums[lne-1];
        }
        for(int i = 1; i < nums.length-1;i++){
            if(nums[i-1] != nums[i] && nums[i+1] != nums[i]){
                return nums[i];
            }
        }
        return 0;
    }

}
